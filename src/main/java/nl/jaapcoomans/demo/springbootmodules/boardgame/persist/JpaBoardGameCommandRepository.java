package nl.jaapcoomans.demo.springbootmodules.boardgame.persist;

import java.util.UUID;

import javax.persistence.EntityManager;

import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGame;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGameCommandRepository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class JpaBoardGameCommandRepository extends SimpleJpaRepository<PersistentBoardGame, UUID> implements BoardGameCommandRepository {
	public JpaBoardGameCommandRepository(final EntityManager entityManager) {
		super(PersistentBoardGame.class, entityManager);
	}

	@Override
	public void persist(final BoardGame boardGame) {
		this.save(PersistentBoardGame.of(boardGame));
	}
}
