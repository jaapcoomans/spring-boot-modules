package nl.jaapcoomans.boardgame.domain;

import nl.jaapcoomans.boardgame.domain.command.CreateBoardGameCommand;

public class BoardGameService {
	private BoardGameCommandRepository boardGameCommandRepository;

	public BoardGameService(final BoardGameCommandRepository boardGameCommandRepository) {
		this.boardGameCommandRepository = boardGameCommandRepository;
	}

	public BoardGame createNewBoardGame(final CreateBoardGameCommand createCommand) {
		BoardGame boardGame = createCommand.execute();
		this.boardGameCommandRepository.persist(boardGame);
		return boardGame;
	}
}
