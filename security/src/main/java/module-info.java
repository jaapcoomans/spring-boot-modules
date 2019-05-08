module nl.jaapcoomans.boardgame.security {
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
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