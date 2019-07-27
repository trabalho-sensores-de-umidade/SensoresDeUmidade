DROP TABLE owners IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE plants IF EXISTS;
DROP TABLE sensors IF EXISTS;
DROP TABLE reads IF EXISTS;


CREATE TABLE owners (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR_IGNORECASE(30),
  email		 VARCHAR(255),
  password	 VARCHAR(255)
);
CREATE INDEX owners_last_name ON owners (last_name);

CREATE TABLE types (
  id                 INTEGER IDENTITY PRIMARY KEY,
  name               VARCHAR(30),
  humidity_minimum   INTEGER NOT NULL,
  humidity_maximum   INTEGER NOT NULL
);
CREATE INDEX types_name ON types (name);

CREATE TABLE plants (
  id                 INTEGER IDENTITY PRIMARY KEY,
  id_type			 INTEGER NOT NULL
);
ALTER TABLE plants ADD CONSTRAINT fk_plants_types FOREIGN KEY (id_type) REFERENCES types (id);

CREATE TABLE sensors (
  id                 INTEGER IDENTITY PRIMARY KEY,
  name               VARCHAR(30),
  id_plant			 INTEGER NOT NULL,
  id_owner			 INTEGER NOT NULL,
  message			 VARCHAR(255)
);
ALTER TABLE sensors ADD CONSTRAINT fk_sensors_plants FOREIGN KEY (id_plant) REFERENCES plants (id);
ALTER TABLE sensors ADD CONSTRAINT fk_sensors_owners FOREIGN KEY (id_owner) REFERENCES owners (id);
CREATE INDEX sensors_name ON sensors (name);

CREATE TABLE reads (
  id                 INTEGER IDENTITY PRIMARY KEY,
  humidity           INTEGER NOT NULL,
  date_read			 DATE, 
  id_sensor			 INTEGER NOT NULL
);
ALTER TABLE reads ADD CONSTRAINT fk_reads_sensors FOREIGN KEY (id_sensor) REFERENCES sensors (id);
