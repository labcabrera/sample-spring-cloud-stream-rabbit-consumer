package com.example.demo.configuration;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import com.example.demo.service.ProcessorService;

@Configuration
public class InboundBindingConfiguration {

	@Bean
	public Consumer<Message<String>> processMessage(ProcessorService service) {
		return service::processMessage;
	}

}