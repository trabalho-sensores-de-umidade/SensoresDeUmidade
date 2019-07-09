package br.com.dbserver.sensorumidade.flower;
import java.util.Random;
import br.com.dbserver.sensorumidade.sensor.SensorUmidade;

public abstract class Flower {

	private static final long serialVersionUID = 1L;
	
	private SensorUmidade sensor;
	
	public int generationNumRandom() {
		Random generation = new Random();
		return generation.nextInt(1023);
	}
}
