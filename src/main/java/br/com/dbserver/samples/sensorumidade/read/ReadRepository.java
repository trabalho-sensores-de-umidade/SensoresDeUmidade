package br.com.dbserver.samples.sensorumidade.read;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface ReadRepository extends Repository<Read, Integer>{

	Collection<Read> findAll();
	
	@Query("SELECT read FROM Read read ORDER BY read.date_read")
	Read findById(@Param("id") Integer id); 
	
    void save(Read read);
    
	void delete(Read read);
    
}
