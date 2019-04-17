package nl.jaapcoomans.demo.springbootmodules.boardgame.bgg.xmlapi;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.NONE)
public class Items {
	@XmlElement(name = "item")
	private List<ItemWithStatistics> items;

	public void setItems(final List<ItemWithStatistics> items) {
		this.items = items;
	}

	public List<ItemWithStatistics> getItems() {
		return items;
	}
}
