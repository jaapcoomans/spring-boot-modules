package nl.jaapcoomans.demo.springbootmodules.boardgame.domain.command;

import java.util.List;
import java.util.UUID;

import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGame;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.GameMechanic;

public class CreateBoardGameCommand {
	private String title;
	private String publisher;
	private String author;
	private int minPlayers;
	private int maxPlayers;
	private List<GameMechanic> gameMechanics;
	private Integer boardGameGeekId;

	public CreateBoardGameCommand(final String title, final String publisher, final String author, final int minPlayers, final int maxPlayers,
		final List<GameMechanic> gameMechanics, final Integer boardGameGeekId) {
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.gameMechanics = gameMechanics;
		this.boardGameGeekId = boardGameGeekId;
	}

	public String getTitle() {
		return title;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getAuthor() {
		return author;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public List<GameMechanic> getGameMechanics() {
		return gameMechanics;
	}

	public Integer getBoardGameGeekId() {
		return boardGameGeekId;
	}

	public BoardGame execute() {
		return new BoardGame(
			UUID.randomUUID(),
			this.title,
			this.author,
			this.publisher,
			this.minPlayers,
			this.maxPlayers,
			this.gameMechanics,
			this.boardGameGeekId);
	}
}
