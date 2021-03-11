package nl.jaapcoomans.boardgame.bgg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import nl.jaapcoomans.boardgame.bgg.xmlapi.BigDecimalValue;
import nl.jaapcoomans.boardgame.bgg.xmlapi.ItemWithStatistics;
import nl.jaapcoomans.boardgame.bgg.xmlapi.Items;
import nl.jaapcoomans.boardgame.bgg.xmlapi.Statistics;
import nl.jaapcoomans.boardgame.bgg.xmlapi.Statistics.Ratings;
import nl.jaapcoomans.boardgame.domain.BoardGame;
import nl.jaapcoomans.boardgame.domain.BoardGameQueryRepository;

import org.junit.jupiter.api.Test;

public class BoardGameGeekRatingServiceTest {
	private static final UUID GAME_ID = UUID.randomUUID();
	private static final int BGG_ID = 42;

	private BoardGameGeekClient bggClient = mock(BoardGameGeekClient.class);
	private BoardGameQueryRepository queryRepository = mock(BoardGameQueryRepository.class);

	@Test
	public void rating_for_known_boardgame_is_successfully_returned() {
		//Given
		BoardGameGeekRatingService boardGameGeekRatingService = new BoardGameGeekRatingService(bggClient, queryRepository);
		when(queryRepository.findBoardGameById(GAME_ID)).thenReturn(Optional.of(createBoardGame(BGG_ID)));
		when(bggClient.getItemsWithRating(BGG_ID)).thenReturn(createBggResponse());

		//When
		Optional<BigDecimal> rating = boardGameGeekRatingService.getAverageRating(GAME_ID);

		//Then
		assertThat(rating).isNotEmpty();
		assertThat(rating).contains(new BigDecimal("8.2"));
	}

	@Test
	public void rating_for_unknown_boardgame_is_empty_optional() {
		//Given
		BoardGameGeekRatingService boardGameGeekRatingService = new BoardGameGeekRatingService(bggClient, queryRepository);
		when(queryRepository.findBoardGameById(GAME_ID)).thenReturn(Optional.empty());

		//When
		Optional<BigDecimal> rating = boardGameGeekRatingService.getAverageRating(GAME_ID);

		//Then
		assertThat(rating).isEmpty();
	}

	@Test
	public void rating_for_game_without_bgg_id_is_empty_optional() {
		//Given
		BoardGameGeekRatingService boardGameGeekRatingService = new BoardGameGeekRatingService(bggClient, queryRepository);
		when(queryRepository.findBoardGameById(GAME_ID)).thenReturn(Optional.of(createBoardGame(null)));

		//When
		Optional<BigDecimal> rating = boardGameGeekRatingService.getAverageRating(GAME_ID);

		//Then
		assertThat(rating).isEmpty();
		verifyZeroInteractions(bggClient);
	}

	private static BoardGame createBoardGame(Integer bggId) {
		return new BoardGame(
			GAME_ID,
			"Test game",
			"Some author",
			"Some publisher",
			2,
			4,
			Collections.emptyList(),
			bggId
		);
	}

	private static Items createBggResponse() {
		BigDecimalValue average = new BigDecimalValue();
		average.setValue(BigDecimal.valueOf(82, 1));

		Ratings ratings = new Ratings();
		ratings.setAverage(average);

		Statistics statistics = new Statistics();
		statistics.setRatings(ratings);

		ItemWithStatistics item = new ItemWithStatistics();
		item.setId(BGG_ID);
		item.setStatistics(statistics);

		Items result = new Items();
		result.setItems(List.of(item));
		return result;
	}
}
