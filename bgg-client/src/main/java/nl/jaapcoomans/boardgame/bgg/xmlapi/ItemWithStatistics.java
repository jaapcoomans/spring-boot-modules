package nl.jaapcoomans.boardgame.bgg.xmlapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class ItemWithStatistics {
	@XmlAttribute
	private int id;

	@XmlElement
	private StringValue name;

	@XmlElement
	private Statistics statistics;

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public StringValue getName() {
		return name;
	}

	public void setName(final StringValue name) {
		this.name = name;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(final Statistics statistics) {
		this.statistics = statistics;
	}
}
