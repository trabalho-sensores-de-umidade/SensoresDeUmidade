package org.springframework.samples.petclinic.plant;

import java.util.Collection;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface PlantRepository extends Repository<Plant, Integer> {

    Collection<Plant> findAll();
   	Plant findById(@Param("id") Integer id);
}