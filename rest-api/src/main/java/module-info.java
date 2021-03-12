module nl.jaapcoomans.boardgame.rest {
	requires nl.jaapcoomans.boardgame.domain;

	requires spring.web;
    requires com.fasterxml.jackson.databind;

	exports nl.jaapcoomans.boardgame.rest;
}