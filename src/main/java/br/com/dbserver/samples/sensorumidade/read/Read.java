package br.com.dbserver.samples.sensorumidade.read;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.dbserver.samples.sensorumidade.model.BaseEntity;
import br.com.dbserver.samples.sensorumidade.sensor.HumiditySensor;

@Entity
@Table(name = "reads")
public class Read extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "humidity")
	private int humidity;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "date_read")
	private LocalTime date_read;
	
	@ManyToOne
	@JoinColumn(name = "id_sensor")
	private HumiditySensor sensor;


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

	public LocalTime getDate_read() {
		return date_read;
	}

	public void setDate_read(LocalTime date_read) {
		this.date_read = date_read;
	}

	@Override
	public String toString() {
		return "Read [humidity=" + humidity + ", sensor=" + sensor + ", date_read=" + date_read + "]";
	}

}
