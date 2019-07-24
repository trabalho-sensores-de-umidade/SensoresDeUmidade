package org.springframework.samples.petclinic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class ServiceEmail {
	private static final Logger log = LoggerFactory.getLogger(ServiceEmail.class);
	private RestTemplate restTemplate;

	public ServiceEmail(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public String getEmail() {
		log.info("Passou aqui");
		return restTemplate.getForObject("http://localhost:8080/email-send", String.class);
	}
}
