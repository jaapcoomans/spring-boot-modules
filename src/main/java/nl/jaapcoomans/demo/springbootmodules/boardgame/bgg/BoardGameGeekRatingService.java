package nl.jaapcoomans.demo.springbootmodules.boardgame.bgg;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import nl.jaapcoomans.demo.springbootmodules.boardgame.bgg.xmlapi.BigDecimalValue;
import nl.jaapcoomans.demo.springbootmodules.boardgame.bgg.xmlapi.ItemWithStatistics;
import nl.jaapcoomans.demo.springbootmodules.boardgame.bgg.xmlapi.Items;
import nl.jaapcoomans.demo.springbootmodules.boardgame.bgg.xmlapi.Statistics;
import nl.jaapcoomans.demo.springbootmodules.boardgame.bgg.xmlapi.Statistics.Ratings;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGame;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGameQueryRepository;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.GameRatingService;

import feign.Feign;
import feign.Logger.ErrorLogger;
import feign.Logger.Level;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

public class BoardGameGeekRatingService implements GameRatingService {
	private BoardGameGeekClient bggClient;
	private BoardGameQueryRepository boardGameQueryRepository;

	public BoardGameGeekRatingService(final String baseUrl, final BoardGameQueryRepository boardGameQueryRepository) {
		this.bggClient = createClient(baseUrl);
		this.boardGameQueryRepository = boardGameQueryRepository;
	}

	private BoardGameGeekClient createClient(String baseUrl) {
		JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
			.withMarshallerJAXBEncoding("UTF-8")
			.build();

		return Feign.builder()
			.encoder(new JAXBEncoder(jaxbFactory))
			.decoder(new JAXBDecoder(jaxbFactory))
			.logger(new ErrorLogger())
			.logLevel(Level.BASIC)
			.target(BoardGameGeekClient.class, baseUrl);
	}

	@Override
	public Optional<BigDecimal> getAverageRating(final UUID gameId) {
		return this.resolveBoardGameGeekId(gameId)
			.map(bggId -> this.bggClient.getItemsWithRating(bggId))
			.map(Items::getItems)
			.map(List::stream)
			.flatMap(Stream::findFirst)
			.map(ItemWithStatistics::getStatistics)
			.map(Statistics::getRatings)
			.map(Ratings::getAverage)
			.map(BigDecimalValue::getValue);
	}

	private Optional<Integer> resolveBoardGameGeekId(UUID gameId) {
		return this.boardGameQueryRepository.findBoardGameById(gameId)
			.map(BoardGame::getBoardGameGeekId);
	}
}
