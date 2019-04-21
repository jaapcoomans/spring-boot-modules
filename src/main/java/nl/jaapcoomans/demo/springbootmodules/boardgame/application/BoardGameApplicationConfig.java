package nl.jaapcoomans.demo.springbootmodules.boardgame.application;

import nl.jaapcoomans.demo.springbootmodules.boardgame.bgg.BoardGameGeekRatingService;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGameCommandRepository;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGameQueryRepository;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGameService;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.GameRatingService;
import nl.jaapcoomans.demo.springbootmodules.boardgame.persist.MongoBoardGameCommandRepository;
import nl.jaapcoomans.demo.springbootmodules.boardgame.persist.MongoBoardGameQueryRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class BoardGameApplicationConfig {
	@Value("${bgg.baseUrl}")
	private String bggBaseUrl;

	@Bean
	public BoardGameService boardGameService(BoardGameCommandRepository boardGameCommandRepository) {
		return new BoardGameService(boardGameCommandRepository);
	}

	@Bean
	public BoardGameQueryRepository boardGameQueryRepository(MongoTemplate mongoTemplate) {
		return new MongoBoardGameQueryRepository(mongoTemplate);
	}

	@Bean
	public BoardGameCommandRepository boardGameCommandRepository(MongoTemplate mongoTemplate) {
		return new MongoBoardGameCommandRepository(mongoTemplate);
	}

	@Bean
	public GameRatingService gameRatingService(BoardGameQueryRepository boardGameQueryRepository) {
		return new BoardGameGeekRatingService(this.bggBaseUrl, boardGameQueryRepository);
	}
}
