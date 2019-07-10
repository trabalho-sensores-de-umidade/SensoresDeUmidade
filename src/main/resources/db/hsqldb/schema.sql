DROP TABLE sensor IF EXISTS;
DROP TABLE plants IF EXISTS;
DROP TABLE reading IF EXISTS;

CREATE TABLE plants (
  id                 INTEGER IDENTITY PRIMARY KEY,
  name               VARCHAR(30),
  moisture_minimum   INTEGER NOT NULL,
  moisture_maximum   INTEGER NOT NULL,
);
CREATE INDEX plants_name ON plants (name);

CREATE TABLE sensor (
  id         INTEGER IDENTITY PRIMARY KEY,
  plant_id         INTEGER NOT NULL,
  name VARCHAR(30),
  
  );
ALTER TABLE reading ADD CONSTRAINT fk_sensor_plants FOREIGN KEY (plant_id) REFERENCES plants (id);
CREATE INDEX sensor_name ON sensor (name);

CREATE TABLE reading (
  id               INTEGER IDENTITY PRIMARY KEY,
  sensor_id        INTEGER NOT NULL,
  reading_date     DATE,
  reading_hour     TIME,
  moisture_current INTEGER
);

ALTER TABLE reading ADD CONSTRAINT fk_reading_sensor FOREIGN KEY (sensor_id) REFERENCES sensor (id);
CREATE INDEX reading_plant_id ON reading (plant_id);











