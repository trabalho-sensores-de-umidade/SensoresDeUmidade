package br.com.dbserver.samples.sensorumidade.plant;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;


@Component
public class PlantFormatter implements Formatter<Plant> {

    private final PlantRepository plants;

    @Autowired
    public PlantFormatter(PlantRepository plants) {
        this.plants = plants;
    }

    @Override
    public String print(Plant plant, Locale locale) {
        return plant.getType().getName();
    }

    @Override
    public Plant parse(String text, Locale locale) throws ParseException {
        Collection<Plant> findplants = this.plants.findPlants();
        for (Plant plant : findplants) {
            if (plant.getType().getName().equals(text)) {
                return plant;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }

}
