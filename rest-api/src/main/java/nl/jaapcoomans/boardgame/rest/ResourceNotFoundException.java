package nl.jaapcoomans.boardgame.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
		super(HttpStatus.NOT_FOUND.getReasonPhrase());
	}
}
