package br.com.dbserver.samples.sensorumidade.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dbserver.samples.sensorumidade.plant.Plant;
import br.com.dbserver.samples.sensorumidade.plant.PlantRepository;
import br.com.dbserver.samples.sensorumidade.read.Read;
import br.com.dbserver.samples.sensorumidade.read.ReadRepository;
import br.com.dbserver.samples.sensorumidade.sensor.HumiditySensor;
import br.com.dbserver.samples.sensorumidade.sensor.HumiditySensorRepository;

@Service
public class SensorServiceImpl implements SensorService {

	private HumiditySensorRepository sensorRepository;
	private PlantRepository plantRepository;
	private ReadRepository readRepository;

	@Autowired
	public SensorServiceImpl(HumiditySensorRepository sensorRepository,PlantRepository plantRepository,ReadRepository readRepository) {
		this.sensorRepository = sensorRepository;
		this.plantRepository = plantRepository;
		this.readRepository = readRepository;
	}

	@Override
	public HumiditySensor findHumiditySensorById(int sensorId) throws DataAccessException {
		HumiditySensor sensor = null;
		try {
			sensor = sensorRepository.findById(sensorId);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			return null;
		}
		return sensor;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<HumiditySensor> findAllHumiditySensor() throws DataAccessException {
		return sensorRepository.findAll();
	}

	@Override
	public void saveHumiditySensor(HumiditySensor sensor) throws DataAccessException {
		sensorRepository.save(sensor);		
	}

	@Override
	@Transactional(readOnly = true)
	public void deleteHumiditySensor(HumiditySensor sensor) throws DataAccessException {
		sensorRepository.delete(sensor);		
	}

	@Override
	public Plant findPlantById(int plantId) throws DataAccessException {
		Plant plant = null;
		try {
			plant = plantRepository.findById(plantId);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			return null;
		}
		return plant;
	}

	@Override
	
	public void savePlant(Plant plant) throws DataAccessException {
		plantRepository.save(plant);
		
	}

	@Override
	public Read findReadById(int readId) throws DataAccessException {
		Read read = null;
		try {
			read = readRepository.findById(readId);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			return null;
		}
		return read;	
	}

	@Override
	public Collection<Read> findAllRead() throws DataAccessException {
		return readRepository.findAll();
	}

	@Override
	public void saveRead(Read read) throws DataAccessException {
		readRepository.save(read);
		
	}

	
}
