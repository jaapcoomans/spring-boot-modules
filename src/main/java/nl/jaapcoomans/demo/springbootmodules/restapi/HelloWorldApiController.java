package nl.jaapcoomans.demo.springbootmodules.restapi;

import nl.jaapcoomans.demo.messages.MessageGenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloWorldApiController {
	private MessageGenerator messageGenerator;

	public HelloWorldApiController(final MessageGenerator messageGenerator) {
		this.messageGenerator = messageGenerator;
	}

	@GetMapping("/world")
	public String world() {
		return this.messageGenerator.generateMessage();
	}

	@GetMapping("/{name}")
	public String world(@PathVariable String name) {
		return this.messageGenerator.generateMessage(name);
	}
}
