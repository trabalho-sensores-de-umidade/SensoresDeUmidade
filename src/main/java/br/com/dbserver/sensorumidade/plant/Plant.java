package br.com.dbserver.sensorumidade.plant;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.dbserver.sensorumidade.model.NamedEntity;
import br.com.dbserver.sensorumidade.owner.Owner;

public class Plant extends NamedEntity {
	
	private static final long serialVersionUID = 1L;
	
		
	@Column(name = "type_id")
	@NotEmpty
	private PlantType type;
	
	@Column(name = "owner_id")
	@NotEmpty
	private Owner owner;
	
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	
	public PlantType getType() {
		return type;
	}

	public void setType(PlantType type) {
		this.type = type;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
		
}
