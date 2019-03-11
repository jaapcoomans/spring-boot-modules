package nl.jaapcoomans.demo.springbootmodules.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloWorldApiController {
	@GetMapping("/world")
	public String world() {
		return "Hello World!";
	}
}
