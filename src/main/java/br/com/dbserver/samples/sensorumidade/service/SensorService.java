package br.com.dbserver.samples.sensorumidade.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import br.com.dbserver.samples.sensorumidade.plant.Plant;
import br.com.dbserver.samples.sensorumidade.read.Read;
import br.com.dbserver.samples.sensorumidade.sensor.HumiditySensor;

public interface SensorService {

	Plant findPlantById(int plantId) throws DataAccessException;
	void savePlant(Plant plant) throws DataAccessException;
	
	Read findReadById(int readId) throws DataAccessException;
	Collection<Read> findAllRead() throws DataAccessException;
	void saveRead(Read read) throws DataAccessException;
	
	HumiditySensor findHumiditySensorById(int sensorId) throws DataAccessException;
	Collection<HumiditySensor> findAllHumiditySensor() throws DataAccessException;
	void saveHumiditySensor(HumiditySensor sensor) throws DataAccessException;
	void deleteHumiditySensor(HumiditySensor sensor) throws DataAccessException;	
	
	
}
