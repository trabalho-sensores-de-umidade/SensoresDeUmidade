package br.com.dbserver.sensorumidade.model;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import br.com.dbserver.sensorumidade.model.BaseEntity;

public class Plant extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "plant_name")
	@NotEmpty
	private String plantName;

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	
		
}
