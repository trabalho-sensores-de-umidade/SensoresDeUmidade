package br.com.dbserver.samples.sensorumidade.plant;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.dbserver.samples.sensorumidade.model.BaseEntity;
import br.com.dbserver.samples.sensorumidade.sensor.HumiditySensor;

@Entity
@Table(name = "plants")
public class Plant extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "plant")
	private Set<HumiditySensor> sensors;
	
	@ManyToOne
	@JoinColumn(name = "id_type")
	private Type type;

	public Set<HumiditySensor> getSensors() {
		return sensors;
	}

	public void setSensors(Set<HumiditySensor> sensors) {
		this.sensors = sensors;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Plant [sensors=" + sensors + ", type=" + type + "]";
	}

	
	
}