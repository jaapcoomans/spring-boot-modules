package nl.jaapcoomans.demo.springbootmodules.boardgame.domain;

import java.math.BigDecimal;
import java.util.Optional;

public interface GameRatingService {
	Optional<BigDecimal> getAverageRating(BoardGame boardGame);
}
