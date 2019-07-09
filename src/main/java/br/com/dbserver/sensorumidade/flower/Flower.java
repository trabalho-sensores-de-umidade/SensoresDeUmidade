package br.com.dbserver.sensorumidade.flower;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;


import br.com.dbserver.sensorumidade.sensor.SensorUmidade;

public abstract class Flower {

	private static final long serialVersionUID = 1L;
	
	private SensorUmidade sensor;
	
	@Column(name = "flower_name")
    @NotEmpty
    private String flowerName;

	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
		
}
