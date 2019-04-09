package nl.jaapcoomans.demo.springbootmodules.boardgame.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BoardGameQueryRepository {
	List<BoardGame> getAllBoardGames();

	Optional<BoardGame> findById(UUID id);
}
