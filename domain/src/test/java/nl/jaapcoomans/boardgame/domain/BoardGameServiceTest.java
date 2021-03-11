package nl.jaapcoomans.boardgame.domain;

import static nl.jaapcoomans.boardgame.domain.GameMechanic.AREA_CONTROL;
import static nl.jaapcoomans.boardgame.domain.GameMechanic.AUCTIONING;
import static nl.jaapcoomans.boardgame.domain.GameMechanic.CARD_DRAFTING;
import static nl.jaapcoomans.boardgame.domain.GameMechanic.HAND_MANAGEMENT;
import static nl.jaapcoomans.boardgame.domain.GameMechanic.MEMORY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import nl.jaapcoomans.boardgame.domain.command.CreateBoardGameCommand;

import org.junit.jupiter.api.Test;

public class BoardGameServiceTest {
	private static final String TITLE = "El Grande";
	private static final String PUBLISHER = "999 Games";
	private static final String AUTHOR = "Wolfgang Kramer, Richard Ulrich";
	private static final int MIN_PLAYERS = 2;
	private static final int MAX_PLAYERS = 5;
	private static final List<GameMechanic> GAME_MECHANICS = List.of(AREA_CONTROL, AUCTIONING, CARD_DRAFTING, HAND_MANAGEMENT, MEMORY);
	private static final int BOARD_GAME_GEEK_ID = 93;

	private BoardGameCommandRepository commandRepository = mock(BoardGameCommandRepository.class);

	@Test
	public void create_command_results_in_creation_and_persistence_of_new_game() {
		// Given
		BoardGameService boardGameService = new BoardGameService(commandRepository);
		CreateBoardGameCommand createBoardGameCommand = createBoardGameCommand();

		// When
		BoardGame created = boardGameService.createNewBoardGame(createBoardGameCommand);

		// Then
		verify(commandRepository).persist(any());

		assertThat(created.getId()).isNotNull();
		assertThat(created.getTitle()).isEqualTo(TITLE);
		assertThat(created.getPublisher()).isEqualTo(PUBLISHER);
		assertThat(created.getAuthor()).isEqualTo(AUTHOR);
		assertThat(created.getMinPlayers()).isEqualTo(MIN_PLAYERS);
		assertThat(created.getMaxPlayers()).isEqualTo(MAX_PLAYERS);
		assertThat(created.getGameMechanics()).isEqualTo(GAME_MECHANICS);
		assertThat(created.getBoardGameGeekId()).isEqualTo(BOARD_GAME_GEEK_ID);
	}

	private CreateBoardGameCommand createBoardGameCommand() {
		return new CreateBoardGameCommand(
			TITLE,
			PUBLISHER,
			AUTHOR,
			MIN_PLAYERS,
			MAX_PLAYERS,
			GAME_MECHANICS,
			BOARD_GAME_GEEK_ID
		);
	}
}
