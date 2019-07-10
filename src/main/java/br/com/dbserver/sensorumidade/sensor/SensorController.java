package br.com.dbserver.sensorumidade.sensor;

import java.io.IOException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

	public class SensorController {

	@GetMapping("/plants/{plantsId}")
	public void reader(@PathVariable("plantsId") int id) {
		ObjectMapper mapper = new ObjectMapper();
	    try {
	        SensorUmidade reading = mapper.readValue(new URL("http://localhost:8080/sensor/{plantsId}"), SensorUmidade.class);
	        System.out.println(reading);
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }	
	}
}
