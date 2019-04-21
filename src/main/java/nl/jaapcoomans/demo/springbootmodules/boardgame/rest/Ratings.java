package nl.jaapcoomans.demo.springbootmodules.boardgame.rest;

import java.math.BigDecimal;

public class Ratings {
	private BigDecimal bggAverage;

	public Ratings(final BigDecimal bggAverage) {
		this.bggAverage = bggAverage;
	}

	public BigDecimal getBggAverage() {
		return bggAverage;
	}
}
