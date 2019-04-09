package nl.jaapcoomans.demo.springbootmodules.boardgame.domain;

import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.command.CreateBoardGameCommand;

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
