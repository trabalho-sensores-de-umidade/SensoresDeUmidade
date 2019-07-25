package br.com.dbserver.samples.sensorumidade.service;

import org.springframework.web.client.RestTemplate;

public class ServiceEmail {
	
	private RestTemplate restTemplate;

	public ServiceEmail(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

//	public String getEmail() {
//		return restTemplate.getForObject("http://localhost:8080/email-send", String.class);
//	}

}
