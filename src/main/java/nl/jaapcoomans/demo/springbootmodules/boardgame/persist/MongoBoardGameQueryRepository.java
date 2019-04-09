package nl.jaapcoomans.demo.springbootmodules.boardgame.persist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGame;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGameQueryRepository;

import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoBoardGameQueryRepository implements BoardGameQueryRepository {
	private MongoTemplate mongoTemplate;

	public MongoBoardGameQueryRepository(final MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<BoardGame> getAllBoardGames() {
		return this.mongoTemplate.findAll(PersistentBoardGame.class).stream()
			.map(PersistentBoardGame::toBoardGame)
			.collect(Collectors.toList());
	}

	@Override
	public Optional<BoardGame> findById(UUID id) {
		return Optional.ofNullable(this.mongoTemplate.findById(id, PersistentBoardGame.class))
			.map(PersistentBoardGame::toBoardGame);
	}
}
