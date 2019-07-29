package br.com.dbserver.samples.sensorumidade.plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

import br.com.dbserver.samples.sensorumidade.model.NamedEntity;

@Entity
@Table(name = "types")
public class Type extends NamedEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "humidity_maximum")
	private int humidity_maximum;

	@Column(name = "humidity_minimum")
	private int humidity_minimum;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
	private Set<Plant> plants;

	public int getHumidity_maximum() {
		return humidity_maximum;
	}

	public void setHumidity_maximum(int humidity_maximum) {
		this.humidity_maximum = humidity_maximum;
	}

	public int getHumidity_minimum() {
		return humidity_minimum;
	}

	public void setHumidity_minimum(int humidity_minimum) {
		this.humidity_minimum = humidity_minimum;
	}
	
    protected Set<Plant> getPlantInternal() {
        if (this.plants == null) {
            this.plants = new HashSet<>();
        }
        return this.plants;
    }

    protected void setPlantInternal(Set<Plant> plants) {
        this.plants = plants;
    }

    public List<Plant> getPlant() {
        List<Plant> sortedPlant = new ArrayList<>(getPlant());
        PropertyComparator.sort(sortedPlant, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedPlant);
    }


    public Plant getPlant(String name) {
        return getPlant(name, false);
    }

    public Plant getPlant(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Plant plant : getPlantInternal()) {
            if (!ignoreNew || !plant.isNew()) {
                String compName = plant.getType().getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return plant;
                }
            }
        }
        return null;
    }
//	@Override
//	public String toString() {
//		return "Type [humidity_maximum=" + humidity_maximum + ", humidity_minimum=" + humidity_minimum + ", plants="
//				+ plants + "]";
//	}

	
    @Override
    public String toString() {
        return new ToStringCreator(this)

            .append("id", this.getId())
            .append("new", this.isNew())
            .append("name", this.getName())
            .append("Humidity_maximum", this.getHumidity_maximum())
            .append("Humidity_minimum", this.getHumidity_minimum())
            //.append("Plants", this.getPlants())
            .toString();
    }

}