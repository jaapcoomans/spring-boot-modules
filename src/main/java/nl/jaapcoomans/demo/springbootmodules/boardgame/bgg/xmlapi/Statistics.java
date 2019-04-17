package nl.jaapcoomans.demo.springbootmodules.boardgame.bgg.xmlapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Statistics {
	@XmlElement
	private Ratings ratings;

	public Ratings getRatings() {
		return ratings;
	}

	public void setRatings(final Ratings ratings) {
		this.ratings = ratings;
	}

	@XmlAccessorType(XmlAccessType.NONE)
	public static class Ratings {
		@XmlElement
		private BigDecimalValue average;

		public BigDecimalValue getAverage() {
			return average;
		}

		public void setAverage(final BigDecimalValue average) {
			this.average = average;
		}
	}
}
