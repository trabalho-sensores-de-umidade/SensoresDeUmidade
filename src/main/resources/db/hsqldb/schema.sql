DROP TABLE sensor IF EXISTS;
DROP TABLE owners IF EXISTS;
DROP TABLE plants IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE reading IF EXISTS;

CREATE TABLE sensor (
  id         INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(30),
  );
CREATE INDEX sensor_name ON sensor (name);

CREATE TABLE owners (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR_IGNORECASE(30),
);
CREATE INDEX owners_last_name ON owners (last_name);

CREATE TABLE types (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX types_name ON types (name);

CREATE TABLE plants (
  id                 INTEGER IDENTITY PRIMARY KEY,
  name               VARCHAR(30),
  moisture_minimum   INTEGER NOT NULL,
  moisture_maximum   INTEGER NOT NULL,
  type_id            INTEGER NOT NULL,
  owner_id           INTEGER NOT NULL
);
ALTER TABLE plants ADD CONSTRAINT fk_plants_owners FOREIGN KEY (owner_id) REFERENCES owners (id);
ALTER TABLE plants ADD CONSTRAINT fk_plants_types FOREIGN KEY (type_id) REFERENCES types (id);
CREATE INDEX plants_name ON plants (name);

CREATE TABLE reading (
  id               INTEGER IDENTITY PRIMARY KEY,
  plant_id         INTEGER NOT NULL,
  sensor_id        INTEGER NOT NULL,
  reading_date     DATE,
  reading_hour     TIME,
  moisture_current INTEGER
);
ALTER TABLE reading ADD CONSTRAINT fk_reading_plants FOREIGN KEY (plant_id) REFERENCES plants (id);
ALTER TABLE reading ADD CONSTRAINT fk_reading_sensor FOREIGN KEY (sensor_id) REFERENCES sensor (id);
CREATE INDEX reading_plant_id ON reading (plant_id);














