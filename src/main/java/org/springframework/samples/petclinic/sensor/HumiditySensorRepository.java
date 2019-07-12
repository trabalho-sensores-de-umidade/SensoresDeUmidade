package org.springframework.samples.petclinic.sensor;

import java.util.Collection;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface HumiditySensorRepository extends Repository<HumiditySensor, Integer>{

	Collection<HumiditySensor> findAll();
	HumiditySensor findById(@Param("id") Integer id);
	
    /**
     * Save an {@link HumiditySensor} to the data store, either inserting or updating it.
     * @param owner the {@link HumiditySensor} to save
     */
    void save(HumiditySensor sensor);
    
	void delete(HumiditySensor sensor);
    
}
