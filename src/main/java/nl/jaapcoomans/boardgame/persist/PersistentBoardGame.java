package nl.jaapcoomans.boardgame.persist;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import nl.jaapcoomans.boardgame.domain.BoardGame;
import nl.jaapcoomans.boardgame.domain.GameMechanic;

@Entity(name = "boardgame")
public class PersistentBoardGame {
	@Id
	private UUID id;

	private String title;
	private String author;
	private String publisher;
	private int minPlayers;
	private int maxPlayers;

	@ElementCollection
	@Enumerated(EnumType.STRING)
	@Column(name = "gameMechanics")
	private List<GameMechanic> gameMechanics;

	private Integer boardGameGeekId;

	public PersistentBoardGame() {}

	public PersistentBoardGame(final UUID id, final String title, final String author, final String publisher, final int minPlayers,
		final int maxPlayers, final List<GameMechanic> gameMechanics, final Integer boardGameGeekId) {

		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.gameMechanics = gameMechanics;
		this.boardGameGeekId = boardGameGeekId;
	}

	public static PersistentBoardGame of(BoardGame boardGame) {
		return new PersistentBoardGame(
			boardGame.getId(),
			boardGame.getTitle(),
			boardGame.getAuthor(),
			boardGame.getPublisher(),
			boardGame.getMinPlayers(),
			boardGame.getMaxPlayers(),
			boardGame.getGameMechanics(),
			boardGame.getBoardGameGeekId());
	}

	BoardGame toBoardGame() {
		return new BoardGame(
			this.id,
			this.title,
			this.author,
			this.publisher,
			this.minPlayers,
			this.maxPlayers,
			this.gameMechanics,
			this.boardGameGeekId);
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

	public Integer getBoardGameGeekId() {
		return boardGameGeekId;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public void setPublisher(final String publisher) {
		this.publisher = publisher;
	}

	public void setMinPlayers(final int minPlayers) {
		this.minPlayers = minPlayers;
	}

	public void setMaxPlayers(final int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public void setGameMechanics(final List<GameMechanic> gameMechanics) {
		this.gameMechanics = gameMechanics;
	}

	public void setBoardGameGeekId(final Integer boardGameGeekId) {
		this.boardGameGeekId = boardGameGeekId;
	}
}
