package br.com.dbserver.sensorumidade.plant;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.dbserver.sensorumidade.model.NamedEntity;

@Entity
@Table(name = "types")
public class PlantType extends NamedEntity {

	private static final long serialVersionUID = 1L;

}
