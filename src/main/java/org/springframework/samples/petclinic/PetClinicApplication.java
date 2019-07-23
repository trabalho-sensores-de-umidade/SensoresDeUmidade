/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.service.ServiceEmail;
//import org.springframework.samples.petclinic.sensor.HumiditySensor;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class PetClinicApplication {

	private static final Logger log = LoggerFactory.getLogger(PetClinicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
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
