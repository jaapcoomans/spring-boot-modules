package nl.jaapcoomans.demo.springbootmodules.boardgame.domain;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface GameRatingService {
	Optional<BigDecimal> getAverageRating(UUID gameId);
}
