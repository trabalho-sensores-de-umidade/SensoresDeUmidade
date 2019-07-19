package org.springframework.samples.petclinic.plant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.NamedEntity;

@Entity
@Table(name = "plants")
public class Plant extends NamedEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "humidity_maximum")
	private int humidity_maximum;

	@Column(name = "humidity_minimum")
	private int humidity_minimum;

	private Integer id_sensor;

	@Column(name = "message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getHumidity_maximum() {
		return humidity_maximum;
	}

	public void setHumidity_maximum(int humidity_maximum) {
		this.humidity_maximum = humidity_maximum;
	}

	public int getHumidity_minimum() {
		return humidity_minimum;
	}

	public void setHumidity_minimum(int humidity_minimum) {
		this.humidity_minimum = humidity_minimum;
	}

	public Integer getSensor() {
		return id_sensor;
	}

	public void setSensor(Integer sensor) {
		this.id_sensor = sensor;
	}

	@Override
	public String toString() {
		return "Plant [humidity_maximum=" + humidity_maximum + ", humidity_minimum=" + humidity_minimum + ", id_sensor="
				+ id_sensor + ", message=" + message + "]";
	}

	
}