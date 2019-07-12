package org.springframework.samples.petclinic.plant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.NamedEntity;

@Entity
@Table(name = "plants")
public class Plant extends NamedEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "moisture_maximum")
	private int moisture_maximum;

	@Column(name = "moisture_minimum")
	private int moisture_minimum;

	private Integer id_sensor;

	@Column(name = "mensagem")
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

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

	public Integer getSensor() {
		return id_sensor;
	}

	public void setSensor(Integer sensor) {
		this.id_sensor = sensor;
	}

	@Override
	public String toString() {
		return String.format("Plant [moisture_maximum=%s, moisture_minimum=%s, id_sensor=%s, mensagem=%s]",
				moisture_maximum, moisture_minimum, id_sensor, mensagem);
	}
	
	

}