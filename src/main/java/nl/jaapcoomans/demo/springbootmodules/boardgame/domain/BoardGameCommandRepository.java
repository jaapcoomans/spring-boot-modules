package nl.jaapcoomans.demo.springbootmodules.boardgame.domain;

public interface BoardGameCommandRepository {
	void persist(BoardGame boardGame);
}
