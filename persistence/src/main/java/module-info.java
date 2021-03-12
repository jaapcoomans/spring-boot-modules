module nl.jaapcoomans.boardgame.persistence {
	requires nl.jaapcoomans.boardgame.domain;

	requires java.persistence;
	requires spring.data.jpa;
	requires spring.tx;

	exports nl.jaapcoomans.boardgame.persist;

	opens nl.jaapcoomans.boardgame.persist to org.hibernate.orm.core, spring.core;
}