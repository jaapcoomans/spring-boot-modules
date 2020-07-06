module nl.jaapcoomans.boardgame.bgg {
	requires nl.jaapcoomans.boardgame.domain;

	requires java.xml.bind;
	requires feign.core;
	requires feign.jaxb;

	exports nl.jaapcoomans.boardgame.bgg.factory;
}