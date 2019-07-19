DROP TABLE owners IF EXISTS;
DROP TABLE plants IF EXISTS;
DROP TABLE sensors IF EXISTS;


CREATE TABLE owners (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR_IGNORECASE(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20),
  email		 VARCHAR(255)
);
CREATE INDEX owners_last_name ON owners (last_name);


CREATE TABLE sensors (
  id                 INTEGER IDENTITY PRIMARY KEY,
  name               VARCHAR(30),
  humidity           INTEGER NOT NULL,
  message 			 VARCHAR(60)
);
CREATE INDEX sensors_name ON sensors (name);

CREATE TABLE plants (
  id                 INTEGER IDENTITY PRIMARY KEY,
  name               VARCHAR(30),
  id_sensor			 INTEGER NOT NULL,
  humidity_minimum   INTEGER NOT NULL,
  humidity_maximum   INTEGER NOT NULL,
  message 			 VARCHAR(60)
);
ALTER TABLE plants ADD CONSTRAINT fk_plants_sensors FOREIGN KEY (id_sensor) REFERENCES sensors (id);
CREATE INDEX plants_name ON plants (name);


