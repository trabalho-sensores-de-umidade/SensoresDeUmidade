package org.springframework.samples.petclinic.service;

import javax.mail.internet.MimeMessage;

//import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController{
	
	@Autowired 
	private JavaMailSender mailSender;
	
	private int plantId;
	private String plantName;
	private int moisture_minimum;
	private int moisture_maximum;
	
	private int sensorId;
	private String sensorName;
	private int humidity;
	
	@RequestMapping(path = "/email-send", method = RequestMethod.GET)
    public String sendMail() {
        try {
        	MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper( mail );
            helper.setTo( "desafiodb2019@gmail.com" );
            helper.setSubject( "Aviso umidade planta: " + getPlantName());
            helper.setText("<p>O sensor "+ getSensorName() + " id: " + getSensorId() + " esta indicando que a umidade da planta "+ getPlantName() + " esta fora da faixa ideal.</p>"
            		+ "<p>Umidade atual: "+ getHumidity() + "%" + "." + "</p><p>Intervalo de umidade ideal "+
            		"umidade minima: " + getMoisture_minimum() + "%" + " umidade máxima: " + getMoisture_maximum() + "%" + "." + "</p>", true);
            mailSender.send(mail);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }

	
	
	public int getHumidity() {
		return humidity;
	}



	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}



	public String getPlantName() {
		return plantName;
	}



	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}



	public int getMoisture_minimum() {
		return moisture_minimum;
	}



	public void setMoisture_minimum(int moisture_minimum) {
		this.moisture_minimum = moisture_minimum;
	}



	public int getMoisture_maximum() {
		return moisture_maximum;
	}



	public void setMoisture_maximum(int moisture_maximum) {
		this.moisture_maximum = moisture_maximum;
	}



	public String getSensorName() {
		return sensorName;
	}



	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}



	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}	
	
}