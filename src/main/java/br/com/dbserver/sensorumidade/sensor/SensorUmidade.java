package br.com.dbserver.sensorumidade.sensor;

import java.util.Random;

public abstract class SensorUmidade {
	
	private static final int pinoVCC = 1;
	private static final int pinoGND = 0;
	
	// Pino de leitura
	private int pinoA0 = 0;
	
	public int getPinoA0() {
		return pinoA0;
	}
	public void setPinoA0(int pinoA0) {
		this.pinoA0 = pinoA0;
	}



	
}
