package br.com.dbserver.samples.sensorumidade.plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import br.com.dbserver.samples.sensorumidade.model.BaseEntity;
import br.com.dbserver.samples.sensorumidade.sensor.HumiditySensor;

@Entity
@Table(name = "plants")
public class Plant extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "plant",fetch = FetchType.EAGER)
	private Set<HumiditySensor> sensors;
		
	@ManyToOne
	@JoinColumn(name = "id_type")
	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
    protected Set<HumiditySensor> getHumiditySensorInternal() {
        if (this.sensors == null) {
            this.sensors = new HashSet<>();
        }
        return this.sensors;
    }

    protected void setHumiditySensorInternal(Set<HumiditySensor> sensors) {
        this.sensors = sensors;
    }

    public List<HumiditySensor> getHumiditySensor() {
        List<HumiditySensor> sortedHumiditySensor = new ArrayList<>(getHumiditySensor());
        PropertyComparator.sort(sortedHumiditySensor, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedHumiditySensor);
    }


    public HumiditySensor getHumiditySensor(String name) {
        return getHumiditySensor(name, false);
    }

    public HumiditySensor getHumiditySensor(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (HumiditySensor sensor : getHumiditySensorInternal()) {
            if (!ignoreNew || !sensor.isNew()) {
                String compName = sensor.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return sensor;
                }
            }
        }
        return null;
    }

	@Override
	public String toString() {
		return "Plant [sensors=" + sensors + ", type=" + type + "]";
	}

    
    
//    @Override
//    public String toString() {
//        return new ToStringCreator(this)
//
//            .append("id", this.getId())
//            //.append("Sensors", this.getHumiditySensor())
//            //.append("Type", this.getType())
//            .toString();
//    }

	
	
}