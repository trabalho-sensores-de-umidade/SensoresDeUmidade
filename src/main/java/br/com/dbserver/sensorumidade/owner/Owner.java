package br.com.dbserver.sensorumidade.owner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;
import org.springframework.samples.petclinic.model.Person;

import br.com.dbserver.sensorumidade.flower.Plant;


@Entity
@Table(name = "owners")
public class Owner extends Person {
	
	private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Plant> plant;

    protected Set<Plant> getPlantsInternal() {
        if (this.plant == null) {
            this.plant = new HashSet<>();
        }
        return this.plant;
    }

    protected void setPlantsInternal(Set<Plant> pets) {
        this.plant = pets;
    }

    public List<Plant> getPlants() {
        List<Plant> sortedPets = new ArrayList<>(getPlantsInternal());
        PropertyComparator.sort(sortedPets,
                new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedPets);
    }

    public void addPet(Plant plant) {
        if (plant.isNew()) {
            getPlantsInternal().add(plant);
        }
        plant.setOwner(this);
    }

    /**
     * Return the Plant with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if plant name is already in use
     */
    public Plant getPlant(String name) {
        return getPlant(name, false);
    }

    /**
     * Return the Plant with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if plant name is already in use
     */
    public Plant getPlant(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Plant plant : getPlantsInternal()) {
            if (!ignoreNew || !plant.isNew()) {
                String compName = plant.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return plant;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId()).append("new", this.isNew())
                .append("lastName", this.getLastName())
                .append("firstName", this.getFirstName()).toString();
    }
}
