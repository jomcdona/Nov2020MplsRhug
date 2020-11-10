package com.redhat.pactproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PactProducerService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	String kafkaTopic = "pact-untranslated";
	
	public void send(String data) {
	    
	    kafkaTemplate.send(kafkaTopic, data);
	}
}