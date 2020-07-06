module nl.jaapcoomans.boardgame.persistence {
	requires nl.jaapcoomans.boardgame.domain;

	requires java.persistence;
	requires spring.data.jpa;
	requires spring.tx;

	exports nl.jaapcoomans.boardgame.persist;
}