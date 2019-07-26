package br.com.dbserver.samples.sensorumidade.plant;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.dbserver.samples.sensorumidade.model.NamedEntity;

@Entity
@Table(name = "types")
public class Type extends NamedEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "humidity_maximum")
	private int humidity_maximum;

	@Column(name = "humidity_minimum")
	private int humidity_minimum;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
	private Set<Plant> plants;

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

	public Set<Plant> getPlants() {
		return plants;
	}

	public void setPlants(Set<Plant> plants) {
		this.plants = plants;
	}

	@Override
	public String toString() {
		return "Type [humidity_maximum=" + humidity_maximum + ", humidity_minimum=" + humidity_minimum + ", plants="
				+ plants + "]";
	}

}