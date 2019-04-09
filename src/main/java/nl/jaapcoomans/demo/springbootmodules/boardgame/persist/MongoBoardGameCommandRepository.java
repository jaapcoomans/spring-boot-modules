package nl.jaapcoomans.demo.springbootmodules.boardgame.persist;

import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGame;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGameCommandRepository;

import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoBoardGameCommandRepository implements BoardGameCommandRepository {
	private MongoTemplate mongoTemplate;

	public MongoBoardGameCommandRepository(final MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void persist(final BoardGame boardGame) {
		this.mongoTemplate.save(PersistentBoardGame.of(boardGame));
	}
}
