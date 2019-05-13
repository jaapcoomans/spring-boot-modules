module nl.jaapcoomans.boardgame.bgg {
	requires nl.jaapcoomans.boardgame.domain;

	requires com.sun.xml.bind;
	requires java.xml.bind;

	requires feign.core;
	requires feign.jaxb;

	exports nl.jaapcoomans.boardgame.bgg.factory;

	opens nl.jaapcoomans.boardgame.bgg.xmlapi;
}