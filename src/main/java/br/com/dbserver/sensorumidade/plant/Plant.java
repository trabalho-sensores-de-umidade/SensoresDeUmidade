package br.com.dbserver.sensorumidade.plant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.dbserver.sensorumidade.model.NamedEntity;

@Entity
@Table(name = "plants")
public class Plant extends NamedEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "moisture_minimum")
	private int moisture_minimum;
	
	@Column(name = "moisture_maximum")
	private int moisture_maximum; 
	

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
		
}
