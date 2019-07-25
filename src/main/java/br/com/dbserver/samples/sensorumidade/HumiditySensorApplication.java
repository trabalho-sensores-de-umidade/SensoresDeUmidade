package br.com.dbserver.samples.sensorumidade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import br.com.dbserver.samples.sensorumidade.service.ServiceEmail;

@SpringBootApplication
public class HumiditySensorApplication {

	private static final Logger log = LoggerFactory.getLogger(HumiditySensorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HumiditySensorApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		log.info(" *** **** Creating a REST Template");
		RestTemplateBuilder builder = new RestTemplateBuilder();
		return builder.build();
	}

	@Bean
	public ServiceEmail sensorService(RestTemplate restTemplate) {
		log.info(" *** **** Creating a Sensor service");
		return new ServiceEmail(restTemplate);
	}

}
