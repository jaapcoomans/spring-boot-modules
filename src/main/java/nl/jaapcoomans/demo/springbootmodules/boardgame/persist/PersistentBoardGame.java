package nl.jaapcoomans.demo.springbootmodules.boardgame.persist;

import java.util.List;
import java.util.UUID;

import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGame;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.GameMechanic;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("boardgames")
public class PersistentBoardGame {
	@Id
	private UUID id;

	private String title;
	private String author;
	private String publisher;
	private int minPlayers;
	private int maxPlayers;
	private List<GameMechanic> gameMechanics;

	public PersistentBoardGame(final UUID id, final String title, final String author, final String publisher, final int minPlayers,
		final int maxPlayers, final List<GameMechanic> gameMechanics) {

		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.gameMechanics = gameMechanics;
	}

	public static PersistentBoardGame of(BoardGame boardGame) {
		return new PersistentBoardGame(
			boardGame.getId(),
			boardGame.getTitle(),
			boardGame.getAuthor(),
			boardGame.getPublisher(),
			boardGame.getMinPlayers(),
			boardGame.getMaxPlayers(),
			boardGame.getGameMechanics()
		);
	}

	BoardGame toBoardGame() {
		return new BoardGame(
			this.id,
			this.title,
			this.author,
			this.publisher,
			this.minPlayers,
			this.maxPlayers,
			this.gameMechanics
		);
	}

	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
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
}
