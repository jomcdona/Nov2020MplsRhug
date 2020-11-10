package com.redhat.pactproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.pactproducer.service.PactProducerService;

@RestController
@RequestMapping(value = "/pact/")
public class PactProducerController {

	@Autowired
	PactProducerService kafkaSender;

	@PostMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.send(message);

		return "Message " + message + "sent to the Kafka Topic pact-untranslated Successfully";
	}

}