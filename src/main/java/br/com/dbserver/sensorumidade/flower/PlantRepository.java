package br.com.dbserver.sensorumidade.flower;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface PlantRepository extends Repository<Plant, Integer> {

	@Query("SELECT plant_type FROM PlantType plant_type ORDER BY plant_type.name")
	@Transactional(readOnly = true)
	List<Plant> findPlantTypes();
	
	@Transactional(readOnly = true)
	Plant findById(Integer id);
	
	void save(Plant plant);
	
}
