package nl.jaapcoomans.boardgame.domain;

public interface BoardGameCommandRepository {
	void persist(BoardGame boardGame);
}
