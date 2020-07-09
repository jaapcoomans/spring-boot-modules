module nl.jaapcoomans.boardgame.security {
	requires org.apache.tomcat.embed.core;
	requires spring.beans;
	requires spring.context;
	requires spring.security.core;
	requires spring.security.config;
	requires spring.security.web;
	requires spring.web;

	requires jjwt.api;

	exports nl.jaapcoomans.boardgame.security;
	exports nl.jaapcoomans.boardgame.security.rest;

	opens nl.jaapcoomans.boardgame.security to spring.core;
}