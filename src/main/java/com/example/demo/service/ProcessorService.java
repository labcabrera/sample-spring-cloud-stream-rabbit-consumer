package com.example.demo.service;

import java.util.Random;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessorService {

	private Random random = new Random();

	public String processMessage(Message<String> message) {
		String text = message.getPayload();

		String processed = text + "-" + random.nextInt(1000);

		log.info("Processing message {}", processed);

		if ("error".equals(text)) {
			throw new RuntimeException("Unhandled demo exception");
		}

		if (text.startsWith("sleep")) {
			log.info("Sleeping for {}", processed);
			try {
				Thread.sleep(10000L);
			}
			catch (InterruptedException ignore) {
			}
		}

		log.info("Finish processing of {}", processed);

		return processed;
	}

}
