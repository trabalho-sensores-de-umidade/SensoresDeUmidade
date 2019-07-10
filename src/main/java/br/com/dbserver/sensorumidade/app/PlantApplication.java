package br.com.dbserver.sensorumidade.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import br.com.dbserver.sensorumidade.sensor.SensorUmidade;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class PlantApplication {

	private static final Logger log = LoggerFactory.getLogger(PlantApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(PlantApplication.class, args);
    }

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build(); 
	}
    
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			SensorUmidade sensor = restTemplate.getForObject(
					"http://localhost:8080/sensor/1", SensorUmidade.class);
			log.info(sensor.toString());
		};
	}
	
}
