package br.com.dbserver.samples.sensorumidade.read;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.dbserver.samples.sensorumidade.model.BaseEntity;
import br.com.dbserver.samples.sensorumidade.sensor.HumiditySensor;

@Entity
@Table(name = "reads")
public class Read extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "humidity")
	private int humidity;

	
	@ManyToOne
	@JoinColumn(name = "id_sensor")
	private HumiditySensor sensor;

	@Column(name = "date_read")
	private String date_read;

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public HumiditySensor getSensor() {
		return sensor;
	}

	public void setSensor(HumiditySensor sensor) {
		this.sensor = sensor;
	}

	public String getDate_read() {
		return date_read;
	}

	public void setDate_read(String date_read) {
		this.date_read = date_read;
	}

	@Override
	public String toString() {
		return "Read [humidity=" + humidity + ", sensor=" + sensor + ", date_read=" + date_read + "]";
	}

}
