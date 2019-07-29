package br.com.dbserver.samples.sensorumidade.sensor;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.dbserver.samples.sensorumidade.model.NamedEntity;
import br.com.dbserver.samples.sensorumidade.owner.Owner;
import br.com.dbserver.samples.sensorumidade.plant.Plant;
import br.com.dbserver.samples.sensorumidade.read.Read;
@Entity
@Table(name = "sensors")
//@JsonSerialize(using = JacksonCustomSensorSerializer.class)

public class HumiditySensor extends NamedEntity {

	private static final long serialVersionUID = 1L;
	

	@Column(name = "message")
	private String message;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_plant")
	private Plant plant;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_owner")
	private Owner owner;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_sensor")
	private Set<Read> reads;
	
    
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

	public Set<Read> getReads() {
		return reads;
	}

	public void setReads(Set<Read> reads) {
		this.reads = reads;
	}

//	@Override
//	public String toString() {
//		return "HumiditySensor [message=" + message + ", plant=" + plant + ", owner=" + owner + ", reads=" + reads
//				+ "]";
//	}
    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", this.getId())
            .append("name", this.getName())
            .append("message", this.getMessage())
            //.append("Owner", this.getOwner())
            //.append("Plant", this.getPlant())
            //.append("Reads", this.getReads())
            .toString();
    }


}
