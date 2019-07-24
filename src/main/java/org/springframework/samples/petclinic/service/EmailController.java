package org.springframework.samples.petclinic.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;

	private int plantId;
	private String plantName;
	private int humidity_minimum;
	private int humidity_maximum;

	private int sensorId;
	private String sensorName;
	private int humidity;
	
	private static final Logger log = LoggerFactory.getLogger(EmailController.class);

	@RequestMapping(path = "/email-send", method = RequestMethod.GET)
	public String sendMail() {
		log.info("Passou aqui");
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo("desafiodb2019@gmail.com");
			helper.setSubject("Plant humidity warning: " + getPlantName());
			helper.setText("<p>The sensor " + getSensorName() + " id: " + getSensorId()
					+ " is indicating that the moisture of the plant " + getPlantName()
					+ " is outside the ideal range.</p>" + "<p>Current humidity: " + getHumidity() + "%" + "."
					+ "</p><p>Ideal humidity range " + "minimum humidity: " + getHumidity_minimum() + "%"
					+ " maximum humidity: " + getHumidity_maximum() + "%" + "." + "</p>", true);
			mailSender.send(mail);
			return "Email successfully sent!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error sending email.";
		}
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public int getHumidity_minimum() {
		return humidity_minimum;
	}

	public void setHumidity_minimum(int humidity_minimum) {
		this.humidity_minimum = humidity_minimum;
	}

	public int getHumidity_maximum() {
		return humidity_maximum;
	}

	public void setHumidity_maximum(int humidity_maximum) {
		this.humidity_maximum = humidity_maximum;
	}

	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
}