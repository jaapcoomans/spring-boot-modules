module nl.jaapcoomans.boardgame.persistence {
	requires transitive nl.jaapcoomans.boardgame.domain;

	requires transitive java.persistence;
	requires spring.data.jpa;
	requires spring.tx;

	exports nl.jaapcoomans.boardgame.persist;
}