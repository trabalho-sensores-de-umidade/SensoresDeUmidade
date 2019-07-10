package br.com.dbserver.sensorumidade.plant;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dbserver.sensorumidade.plant.PlantRepository;

@Controller
@RequestMapping("/plants/{plantsId}")
public class PlantController {
	
	private final PlantRepository plantR;
	
	public PlantController(PlantRepository plantR) {
		super();
		this.plantR = plantR;
	}
	
		
	@GetMapping("/plants")
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
