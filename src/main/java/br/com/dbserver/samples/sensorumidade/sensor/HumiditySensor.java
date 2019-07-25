package br.com.dbserver.samples.sensorumidade.sensor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.dbserver.samples.sensorumidade.model.NamedEntity;
import br.com.dbserver.samples.sensorumidade.plant.Plant;


@Entity
@Table(name = "sensors")
public class HumiditySensor extends NamedEntity{
	
	private static final long serialVersionUID = 1L;
	
    @Column(name = "humidity")
    private int humidity;
        
    @ManyToOne
    @JoinColumn(name = "id_plant")
    private Plant plant;
    
    public int getHumidity() {
		return humidity;
	}
	
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
}
