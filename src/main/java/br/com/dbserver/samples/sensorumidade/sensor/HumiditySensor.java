package br.com.dbserver.samples.sensorumidade.sensor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.mail.handlers.message_rfc822;

import br.com.dbserver.samples.sensorumidade.model.NamedEntity;
import br.com.dbserver.samples.sensorumidade.owner.Owner;
import br.com.dbserver.samples.sensorumidade.plant.Plant;

@Entity
@Table(name = "sensors")
public class HumiditySensor extends NamedEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "message")
	private String message;

	@ManyToOne
	@JoinColumn(name = "id_plant")
	private Plant plant;

	@ManyToOne
	@JoinColumn(name = "id_owner")
	private Owner owner;

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
	
		return "HumiditySensor [message=" + message + ", plant=" + plant + ", owner=" + owner + "]";
	}

}
