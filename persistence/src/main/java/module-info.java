module nl.jaapcoomans.boardgame.persistence {
	requires transitive nl.jaapcoomans.boardgame.domain;

	requires java.persistence;
	requires spring.data.jpa;
	requires spring.tx;

	exports nl.jaapcoomans.boardgame.persist;

	opens nl.jaapcoomans.boardgame.persist to spring.core, org.hibernate.orm.core;
}