package nl.jaapcoomans.demo.springbootmodules.boardgame.bgg.xmlapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.NONE)
public class BigDecimalValue {
	@XmlAttribute
	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(final BigDecimal value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
