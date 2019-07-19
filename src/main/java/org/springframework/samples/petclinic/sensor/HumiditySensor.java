package org.springframework.samples.petclinic.sensor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.NamedEntity;


@Entity
@Table(name = "sensors")
public class HumiditySensor extends NamedEntity{
	
	private static final long serialVersionUID = 1L;
	
    @Column(name = "humidity")
    private int humidity;
    private String message;
    
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getHumidity() {
		return humidity;
	}
	
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return String.format("HumiditySensor [humidity=%s, message=%s]", humidity, message);
	}
	
	
	
}
