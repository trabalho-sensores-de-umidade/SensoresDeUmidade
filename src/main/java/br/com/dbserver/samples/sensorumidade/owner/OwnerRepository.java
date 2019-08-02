package br.com.dbserver.samples.sensorumidade.owner;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OwnerRepository extends Repository<Owner, Integer> {

	Collection<Owner> findAll();
	
	@Query("SELECT DISTINCT owner FROM Owner owner  WHERE owner.lastName LIKE :lastName%")
	@Transactional(readOnly = true)
	Collection<Owner> findByLastName(@Param("lastName") String lastName);

	@Query("SELECT owner FROM Owner owner left join fetch owner.sensors WHERE owner.id =:id")
	@Transactional(readOnly = true)
	Owner findById(@Param("id") Integer id);
	
    @Query("SELECT owner FROM Owner owner ORDER BY owner.id")
    @Transactional(readOnly = true)
    List<Owner> findOwners();  

	void save(Owner owner);

}
