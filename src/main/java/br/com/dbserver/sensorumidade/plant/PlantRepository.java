package br.com.dbserver.sensorumidade.plant;

import java.util.Collection;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface PlantRepository extends Repository<Plant, Integer> {

	Collection<Plant> findAll();	
	
	@Transactional(readOnly = true)
	Plant findById(Integer id);
	
	void save(Plant plant);
	
}
