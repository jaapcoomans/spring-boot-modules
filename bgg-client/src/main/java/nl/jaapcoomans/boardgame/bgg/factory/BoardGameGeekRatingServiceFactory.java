package nl.jaapcoomans.boardgame.bgg.factory;

import nl.jaapcoomans.boardgame.bgg.BoardGameGeekClient;
import nl.jaapcoomans.boardgame.bgg.BoardGameGeekRatingService;
import nl.jaapcoomans.boardgame.domain.BoardGameQueryRepository;
import nl.jaapcoomans.boardgame.domain.GameRatingService;

import feign.Feign;
import feign.Logger.ErrorLogger;
import feign.Logger.Level;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

public final class BoardGameGeekRatingServiceFactory {
	private BoardGameGeekRatingServiceFactory(){}

	public static GameRatingService createBoardGameRatingService(String baseUrl, BoardGameQueryRepository queryRepository) {
		return new BoardGameGeekRatingService(createBoardGameGeekClient(baseUrl), queryRepository);
	}

	private static BoardGameGeekClient createBoardGameGeekClient(final String baseUrl) {
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
}
