module nl.jaapcoomans.boardgame.bgg {
	requires transitive nl.jaapcoomans.boardgame.domain;

	requires java.xml.bind;
	requires feign.core;
	requires feign.jaxb;

	exports nl.jaapcoomans.boardgame.bgg.factory;

	opens nl.jaapcoomans.boardgame.bgg.xmlapi to java.xml.bind;
}