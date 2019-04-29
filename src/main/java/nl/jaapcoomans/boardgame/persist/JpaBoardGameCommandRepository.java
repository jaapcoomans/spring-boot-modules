package nl.jaapcoomans.boardgame.persist;

import java.util.UUID;

import javax.persistence.EntityManager;

import nl.jaapcoomans.boardgame.domain.BoardGameCommandRepository;
import nl.jaapcoomans.boardgame.domain.BoardGame;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JpaBoardGameCommandRepository extends SimpleJpaRepository<PersistentBoardGame, UUID> implements BoardGameCommandRepository {
	public JpaBoardGameCommandRepository(final EntityManager entityManager) {
		super(PersistentBoardGame.class, entityManager);
	}

	@Override
	public void persist(final BoardGame boardGame) {
		this.save(PersistentBoardGame.of(boardGame));
	}
}
