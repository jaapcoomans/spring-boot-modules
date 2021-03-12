module nl.jaapcoomans.boardgame.domain {
	requires kotlin.stdlib;
	exports nl.jaapcoomans.boardgame.domain;
	exports nl.jaapcoomans.boardgame.domain.command;

	opens nl.jaapcoomans.boardgame.domain.command to com.fasterxml.jackson.databind;
}