package nl.jaapcoomans.demo.springbootmodules.boardgame.persist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGame;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGameQueryRepository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class JpaBoardGameQueryRepository extends SimpleJpaRepository<PersistentBoardGame, UUID> implements BoardGameQueryRepository {
	public JpaBoardGameQueryRepository(final EntityManager em) {
		super(PersistentBoardGame.class, em);
	}

	@Override
	public List<BoardGame> getAllBoardGames() {
		return this.findAll().stream()
			.map(PersistentBoardGame::toBoardGame)
			.collect(Collectors.toList());
	}

	@Override
	public Optional<BoardGame> findBoardGameById(final UUID id) {
		return this.findById(id)
			.map(PersistentBoardGame::toBoardGame);
	}
}
