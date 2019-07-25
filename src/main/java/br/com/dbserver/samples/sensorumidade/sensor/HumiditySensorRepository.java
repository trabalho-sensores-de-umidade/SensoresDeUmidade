package br.com.dbserver.samples.sensorumidade.sensor;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.dbserver.samples.sensorumidade.plant.Plant;

public interface HumiditySensorRepository extends Repository<HumiditySensor, Integer>{

	Collection<HumiditySensor> findAll();
	
	HumiditySensor findById(@Param("id") Integer id);
	
    @Query("SELECT plant FROM Plant plant ORDER BY plant.name")
    @Transactional(readOnly = true)
    List<Plant> findPlants();
	
    void save(HumiditySensor sensor);
    
	void delete(HumiditySensor sensor);
    
}
