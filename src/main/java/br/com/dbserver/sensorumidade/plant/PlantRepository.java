package br.com.dbserver.sensorumidade.plant;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface PlantRepository extends Repository<Plant, Integer> {

	Collection<Plant> findAll();
	
	@Query("SELECT plant_type FROM PlantType plant_type ORDER BY plant_type.name")
	@Transactional(readOnly = true)
	List<PlantType> findPlantTypes();
	
	@Transactional(readOnly = true)
	Plant findById(Integer id);
	
	void save(Plant plant);
	
}
