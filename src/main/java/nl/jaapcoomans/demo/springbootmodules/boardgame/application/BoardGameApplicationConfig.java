package nl.jaapcoomans.demo.springbootmodules.boardgame.application;

import javax.persistence.EntityManager;

import nl.jaapcoomans.demo.springbootmodules.boardgame.bgg.BoardGameGeekRatingService;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGameCommandRepository;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGameQueryRepository;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.BoardGameService;
import nl.jaapcoomans.demo.springbootmodules.boardgame.domain.GameRatingService;
import nl.jaapcoomans.demo.springbootmodules.boardgame.persist.JpaBoardGameCommandRepository;
import nl.jaapcoomans.demo.springbootmodules.boardgame.persist.JpaBoardGameQueryRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardGameApplicationConfig {
	@Value("${bgg.baseUrl}")
	private String bggBaseUrl;

	@Bean
	public BoardGameService boardGameService(BoardGameCommandRepository boardGameCommandRepository) {
		return new BoardGameService(boardGameCommandRepository);
	}

	@Bean
	public BoardGameQueryRepository boardGameQueryRepository(EntityManager entityManager) {
		return new JpaBoardGameQueryRepository(entityManager);
	}

	@Bean
	public BoardGameCommandRepository boardGameCommandRepository(EntityManager entityManager) {
		return new JpaBoardGameCommandRepository(entityManager);
	}

	@Bean
	public GameRatingService gameRatingService(BoardGameQueryRepository boardGameQueryRepository) {
		return new BoardGameGeekRatingService(this.bggBaseUrl, boardGameQueryRepository);
	}
}
