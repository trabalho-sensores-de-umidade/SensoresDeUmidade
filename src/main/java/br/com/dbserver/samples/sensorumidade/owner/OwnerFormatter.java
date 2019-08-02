package br.com.dbserver.samples.sensorumidade.owner;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;


@Component
public class OwnerFormatter implements Formatter<Owner> {

    private final OwnerRepository owners;


    @Autowired
    public OwnerFormatter(OwnerRepository owners) {
        this.owners = owners;
    }

    @Override
    public String print(Owner owner, Locale locale) {
        return owner.getFirstName();
    }

    @Override
    public Owner parse(String text, Locale locale) throws ParseException {
        Collection<Owner> findOwners = this.owners.findOwners();
        for (Owner owner : findOwners) {
            if (owner.getFirstName().equals(text)) {            	
                return owner;  
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }


}
