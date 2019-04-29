package nl.jaapcoomans.boardgame.rest;

import java.util.List;
import java.util.UUID;

import nl.jaapcoomans.boardgame.domain.BoardGameQueryRepository;
import nl.jaapcoomans.boardgame.domain.BoardGameService;
import nl.jaapcoomans.boardgame.domain.GameRatingService;
import nl.jaapcoomans.boardgame.domain.command.CreateBoardGameCommand;
import nl.jaapcoomans.boardgame.domain.BoardGame;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boardgames")
public class BoardGameRestApi {
	private BoardGameQueryRepository boardGameQueryRepository;
	private BoardGameService boardGameService;
	private GameRatingService gameRatingService;

	public BoardGameRestApi(final BoardGameQueryRepository boardGameQueryRepository, final BoardGameService boardGameService,
		final GameRatingService gameRatingService) {

		this.boardGameQueryRepository = boardGameQueryRepository;
		this.boardGameService = boardGameService;
		this.gameRatingService = gameRatingService;
	}

	@GetMapping
	public List<BoardGame> getAllBoardGames() {
		return this.boardGameQueryRepository.getAllBoardGames();
	}

	@GetMapping("/{id}")
	public BoardGame getBoardGameById(@PathVariable UUID id) {
		return this.boardGameQueryRepository.findBoardGameById(id)
			.orElseThrow(ResourceNotFoundException::new);
	}

	@PostMapping
	public BoardGame createNewBoardGame(@RequestBody CreateBoardGameCommand createCommand) {
		return this.boardGameService.createNewBoardGame(createCommand);
	}

	@GetMapping("/{gameId}/ratings")
	public Ratings getRatingsById(@PathVariable UUID gameId) {
		return this.gameRatingService.getAverageRating(gameId)
			.map(Ratings::new)
			.orElseThrow(ResourceNotFoundException::new);
	}
}
