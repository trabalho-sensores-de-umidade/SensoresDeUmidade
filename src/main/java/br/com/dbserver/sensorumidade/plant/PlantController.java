package br.com.dbserver.sensorumidade.plant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dbserver.sensorumidade.owner.Owner;
import br.com.dbserver.sensorumidade.owner.OwnerRepository;
import br.com.dbserver.sensorumidade.plant.PlantRepository;

@Controller
@RequestMapping("/owners/{ownersId}")
public class PlantController {

	private final PlantRepository plantR;
	private final OwnerRepository owners;
	
	public PlantController(PlantRepository plantR, OwnerRepository owners) {
		super();
		this.plantR = plantR;
		this.owners = owners;
	}
	
	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") int ownerId) {
		return this.owners.findById(ownerId);
	}
	
	
	
}
