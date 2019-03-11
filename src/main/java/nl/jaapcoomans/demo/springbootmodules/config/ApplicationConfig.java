package nl.jaapcoomans.demo.springbootmodules.config;

import nl.jaapcoomans.demo.messages.MessageGenerator;
import nl.jaapcoomans.demo.messages.impl.MessageGeneratorImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	@Bean
	public MessageGenerator messageGenerator() {
		return new MessageGeneratorImpl();
	}
}
