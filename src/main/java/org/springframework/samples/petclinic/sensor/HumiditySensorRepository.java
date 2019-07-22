package org.springframework.samples.petclinic.sensor;

import java.util.Collection;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface HumiditySensorRepository extends Repository<HumiditySensor, Integer>{

	Collection<HumiditySensor> findAll();
	HumiditySensor findById(@Param("id") Integer id);
	
    void save(HumiditySensor sensor);
    
	void delete(HumiditySensor sensor);
    
}
