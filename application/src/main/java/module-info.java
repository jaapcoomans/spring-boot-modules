module nl.jaapcoomans.boardgame.application {
	requires nl.jaapcoomans.boardgame.bgg;
	requires nl.jaapcoomans.boardgame.persistence;
	requires nl.jaapcoomans.boardgame.rest;
	requires nl.jaapcoomans.boardgame.security;

	requires java.instrument;
	requires java.sql;
	requires net.bytebuddy;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.beans;
	requires spring.context;

	exports nl.jaapcoomans.boardgame;
	exports nl.jaapcoomans.boardgame.application;

	opens nl.jaapcoomans.boardgame to spring.core;
	opens nl.jaapcoomans.boardgame.application to spring.core;
}