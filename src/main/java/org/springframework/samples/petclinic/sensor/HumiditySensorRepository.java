package org.springframework.samples.petclinic.sensor;

import org.springframework.data.repository.Repository;

public interface HumiditySensorRepository extends Repository<HumiditySensor, Integer>{

	
    /**
     * Save an {@link HumiditySensor} to the data store, either inserting or updating it.
     * @param owner the {@link HumiditySensor} to save
     */
    void save(HumiditySensor sensor);
    
}
