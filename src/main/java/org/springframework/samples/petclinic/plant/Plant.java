package org.springframework.samples.petclinic.plant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.sensor.HumiditySensor;

@Entity
@Table(name = "plants")
public class Plant extends NamedEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "moisture_maximum")
	private int moisture_maximum;
	
	@Column(name = "moisture_minimum")
	private int moisture_minimum;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "plant")
    private HumiditySensor sensor;

	public int getMoisture_maximum() {
		return moisture_maximum;
	}

	public void setMoisture_maximum(int moisture_maximum) {
		this.moisture_maximum = moisture_maximum;
	}

	public int getMoisture_minimum() {
		return moisture_minimum;
	}

	public void setMoisture_minimum(int moisture_minimum) {
		this.moisture_minimum = moisture_minimum;
	}

	public HumiditySensor getSensor() {
		return sensor;
	}

	public void setSensor(HumiditySensor sensor) {
		this.sensor = sensor;
	}
	
		
}