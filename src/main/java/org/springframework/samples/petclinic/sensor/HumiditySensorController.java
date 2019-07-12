package org.springframework.samples.petclinic.sensor;

import java.io.IOException;
import java.net.URL;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HumiditySensorController {

	

	@GetMapping("/plantSensor")
	public void reader(@PathVariable("plantsId") int id) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			HumiditySensor reading = mapper.readValue(new URL("http://localhost:8080/sensor/{plantsId}"),
					HumiditySensor.class);
			System.out.println(reading);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
