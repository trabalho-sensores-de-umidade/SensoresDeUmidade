package br.com.dbserver.samples.sensorumidade.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dbserver.samples.sensorumidade.read.Read;
import br.com.dbserver.samples.sensorumidade.sensor.HumiditySensor;

@RestController
@RequestMapping("/service")
@CrossOrigin(exposedHeaders = "errors, content-type")
public class SensorRestController {

	@Autowired
	private SensorService sensorservice;

	@Autowired
	private EmailController email;

//	@RequestMapping(value = "/{sensorId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@Transactional
//	public ResponseEntity<Void> updateSensor(@PathVariable("sensorId") int sensorId, HumiditySensor sensor,
//			UriComponentsBuilder ucBuilder) {
//		HumiditySensor currentsensor = this.sensorservice.findHumiditySensorById(sensorId);
//		Plant currentplant = this.sensorservice.findPlantById(sensorId);
//		if (currentsensor == null) {
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//		}
//
//		currentsensor.setId(sensor.getId());
//		currentsensor.setHumidity(sensor.getHumidity());
//		if (currentsensor.getHumidity() < currentplant.getHumidity_minimum()
//				|| currentsensor.getHumidity() > currentplant.getHumidity_maximum()) {
//			currentplant.setMessage("The humidity of the plant is outside the ideal range");
//			email.setPlantAndSensor(currentplant, currentsensor);
//			email.sendMail();
//			//service.getEmail();
//		} else {
//			currentplant.setMessage("The humidity of the plant is within the ideal range");
//		}
//		this.sensorservice.saveHumiditySensor(currentsensor);
//		this.sensorservice.savePlant(currentplant);
//
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
//
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Read> addOwner(@RequestBody @Valid Read read, BindingResult bindingResult,
			UriComponentsBuilder ucBuilder) {
		HttpHeaders headers = new HttpHeaders();
		if (bindingResult.hasErrors() || (read == null)) {
			return new ResponseEntity<Read>(headers, HttpStatus.BAD_REQUEST);
		}
		
		
		this.sensorservice.saveRead(read);
		headers.setLocation(ucBuilder.path("/service/{id}").buildAndExpand(read.getId()).toUri());
		
		HumiditySensor currentsensor = this.sensorservice.findHumiditySensorById(read.getSensor().getId());
		read.getSensor().getPlant().getType().getHumidity_maximum();
		
		if (read.getHumidity() < read.getSensor().getPlant().getType().getHumidity_minimum()
				|| read.getHumidity() > read.getSensor().getPlant().getType().getHumidity_maximum()) {
			read.getSensor().setMessage("The humidity of the plant is outside the ideal range");
			email.setRead(read);
			email.sendMail();
			//service.getEmail();
		} else {
			read.getSensor().setMessage("The humidity of the plant is within the ideal range");
		}
		this.sensorservice.saveHumiditySensor(currentsensor);
		return new ResponseEntity<Read>(read, headers, HttpStatus.CREATED);
	}
	
//	@RequestMapping(value = "/{sensorId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ResponseEntity<HumiditySensor> getHumiditySensor(@PathVariable("sensorId") int sensorId) {
//		HumiditySensor sensor = null;
//		sensor = this.sensorservice.findHumiditySensorById(sensorId);
//		if (sensor == null) {
//			return new ResponseEntity<HumiditySensor>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<HumiditySensor>(sensor, HttpStatus.OK);
//	}

}
