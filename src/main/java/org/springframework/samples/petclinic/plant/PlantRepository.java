package org.springframework.samples.petclinic.plant;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PlantRepository extends Repository<Plant, Integer> {

    Collection<Plant> findAll();
    
    //@Query("SELECT p.id FROM Plants p join Sensors s WHERE p.id =s.id")
    @Transactional(readOnly = true)
   	Plant findById(@Param("id") Integer id);

	void save(Plant plant);
}