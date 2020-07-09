module nl.jaapcoomans.boardgame.rest {
	requires transitive nl.jaapcoomans.boardgame.domain;

	requires spring.web;

	exports nl.jaapcoomans.boardgame.rest;
}