package br.com.dbserver.samples.sensorumidade.read;


import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.dbserver.samples.sensorumidade.model.BaseEntity;
import br.com.dbserver.samples.sensorumidade.sensor.HumiditySensor;
@Entity
@Table(name = "reads")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Read extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	@Column(name = "humidity")
	private int humidity;
	
	//@JsonProperty
    @Column(name = "date_read") 
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime date_read = LocalDateTime.now();
    
    @JsonProperty
	@ManyToOne
	@JoinColumn(name = "id_sensor")
	private HumiditySensor id_sensor;


	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	

	public HumiditySensor getSensor() {
		return id_sensor; 
	}

	public void setSensor(HumiditySensor id_sensor) {
		this.id_sensor = id_sensor;
	}

	public LocalDateTime getDate_read() {
		return date_read;
	}

	public void setDate_read(LocalDateTime date_read) {
		this.date_read = date_read;
	}

	@Override
	public String toString() {
		return "Read [humidity=" + humidity + ", date_read=" + date_read + ", id_sensor=" + id_sensor + "]";
	}




//    @Override
//    public String toString() {
//        return new ToStringCreator(this)
//            .append("id", this.getId())
//            .append("humidity", this.getHumidity())
//           // .append("sensor", this.getSensor())
//            .append("date_read", this.getDate_read())
//            .toString();
//    }
}
