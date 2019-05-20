module nl.jaapcoomans.boardgame.application {
	requires nl.jaapcoomans.boardgame.bgg;
	requires nl.jaapcoomans.boardgame.persistence;
	requires nl.jaapcoomans.boardgame.rest;
	requires nl.jaapcoomans.boardgame.security;

	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.beans;
	requires spring.context;
	requires java.persistence;

	requires net.bytebuddy;
	requires jdk.unsupported;

	exports nl.jaapcoomans.boardgame;
	exports nl.jaapcoomans.boardgame.application;

	opens nl.jaapcoomans.boardgame to spring.core;
	opens nl.jaapcoomans.boardgame.application to spring.core;
}