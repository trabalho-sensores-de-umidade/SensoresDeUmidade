package br.com.dbserver.samples.sensorumidade.read;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.dbserver.samples.sensorumidade.model.BaseEntity;
import br.com.dbserver.samples.sensorumidade.sensor.HumiditySensor;
@Entity
@Table(name = "reads")
public class Read extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "humidity")
	private int humidity;

    @Column(name = "date_read")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date date_read;
	
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

	public Date getDate_read() {
		return date_read;
	}

	public void setDate_read(Date date_read) {
		this.date_read = date_read;
	}

	@Override
	public String toString() {
		return "Read [humidity=" + humidity + ", sensor=" + sensor + ", date_read=" + date_read + "]";
	}

}
