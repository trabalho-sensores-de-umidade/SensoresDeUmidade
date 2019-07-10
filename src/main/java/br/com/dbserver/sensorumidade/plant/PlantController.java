package br.com.dbserver.sensorumidade.plant;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@ModelAttribute("types")
	public Collection<PlantType> populatePlantTypes(){
		return this.plantR.findPlantTypes();
	}
	
	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") int ownerId) {
		return this.owners.findById(ownerId);
	}
	
	@GetMapping("plants")
	public String processFindForm(Model model) {
		Collection<Plant> plantList = plantR.findAll();
		model.addAttribute("plants", plantList);
		return "plants/plantsList";
	}
	
	@GetMapping("/plants/{plantsId}")
	public ModelAndView showPlants(@PathVariable("plantsId") int plantsId) {
		ModelAndView mav = new ModelAndView("plants/plantsDetails");
		mav.addObject(this.plantR.findById(plantsId));
		return mav;
	}
	
}
