package br.com.dbserver.samples.sensorumidade.service;

import javax.mail.internet.MimeMessage;

//import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.samples.sensorumidade.read.Read;

@RestController
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;

	private Read read;

	@RequestMapping(path = "/email-send")
	public String sendMail() {
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo("desafiodb2019@gmail.com");
			helper.setSubject("Plant humidity warning: " + read.getSensor().getPlant().getType().getName());
			helper.setText("<p>The sensor " + read.getSensor().getName() + " id: " + read.getSensor().getId()
					+ " is indicating that the moisture of the plant " + read.getSensor().getPlant().getType().getName()
					+ " is outside the ideal range.</p>" + "<p>Current humidity: " + read.getHumidity()  + "%" + "."
					+ "</p><p>Ideal humidity range " + "minimum humidity: " + read.getSensor().getPlant().getType().getHumidity_minimum() + "%"
					+ " maximum humidity: " + read.getSensor().getPlant().getType().getHumidity_maximum() + "%" + "." + "</p>", true);
			mailSender.send(mail);
			return "Email successfully sent!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error sending email.";
		}
	}
	
	public void setRead(Read read) {
		this.read = read;
	}

}