package br.com.dbserver.sensorumidade.sensor;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class SensorUmidade {
	
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
    private String nome;
    private int umidade_atual;
    
	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getUmidade_atual() {
		return umidade_atual;
	}
	
	public void setUmidade_atual(int umidade_atual) {
		this.umidade_atual = umidade_atual;
	}
	
	@Override
	public String toString() {
		return "Sensor [id=" + id + ", nome=" + nome + ", umidade_atual=" + umidade_atual + "]";
	}
     



}
