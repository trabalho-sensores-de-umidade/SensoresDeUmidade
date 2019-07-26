package br.com.dbserver.samples.sensorumidade.plant;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class TypeFormatter implements Formatter<Type> {

    private final PlantRepository plants;


    @Autowired
    public TypeFormatter(PlantRepository plants) {
        this.plants = plants;
    }

    @Override
    public String print(Type plantType, Locale locale) {
        return plantType.getName();
    }

    @Override
    public Type parse(String text, Locale locale) throws ParseException {
        Collection<Type> findPlantTypes = this.plants.findPlantTypes();
        for (Type type : findPlantTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }

}
