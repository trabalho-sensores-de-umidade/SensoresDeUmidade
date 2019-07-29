package br.com.dbserver.samples.sensorumidade.owner;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import br.com.dbserver.samples.sensorumidade.model.Person;
import br.com.dbserver.samples.sensorumidade.sensor.HumiditySensor;

@Entity
@Table(name = "owners")
public class Owner extends Person {

	private static final long serialVersionUID = 1L;

	@Column(name = "email")
	@NotEmpty
	private String email;

	@Column(name = "password")
	@NotEmpty
	private String password;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<HumiditySensor> sensors;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<HumiditySensor> getSensors() {
		return sensors;
	}

	public void setSensors(Set<HumiditySensor> sensors) {
		this.sensors = sensors;
	}

//    @Override
//    public String toString() {
//        return new ToStringCreator(this)
//
//                .append("id", this.getId())
//                .append("email", this.getEmail())
//                .append("lastName", this.getLastName())
//                .append("firstName", this.getFirstName())
//                .append("firstName", this.getPassword())
//                .append("Sensors", this.getSensors())
//                .toString();
//    }

}
