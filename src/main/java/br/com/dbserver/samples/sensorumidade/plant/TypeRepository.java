package br.com.dbserver.samples.sensorumidade.plant;

import java.util.Collection;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TypeRepository extends Repository<Type, Integer> {

    Collection<Type> findAll();
    
  //  @Query("SELECT type FROM Type type JOIN fetch type.plants WHERE type.id =:id")
    @Transactional(readOnly = true)
    Type findById(@Param("id") Integer id);
    
    void save(Type type);
}