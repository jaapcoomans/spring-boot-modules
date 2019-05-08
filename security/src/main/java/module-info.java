module nl.jaapcoomans.boardgame.security {
	requires spring.beans;
	requires spring.context;
	requires spring.security.core;
	requires spring.security.config;
	requires spring.security.web;
	requires spring.web;

	requires jjwt.api;
	requires tomcat.embed.core;

	exports nl.jaapcoomans.boardgame.security;
	exports nl.jaapcoomans.boardgame.security.rest;
}