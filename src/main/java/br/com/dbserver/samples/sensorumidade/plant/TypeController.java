package br.com.dbserver.samples.sensorumidade.plant;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
class TypeController {
	private final TypeRepository types;
	
	public TypeController(TypeRepository types) {
		super();
		this.types = types;
	}

	//@GetMapping("/types")
	public String processFindForm(Model model) {
		Collection<Type> typesList = types.findAll();
		model.addAttribute("types", typesList);
		return "types/typesList";
	}

	
	//@GetMapping("/types/{typeId}")
	public ModelAndView showType(@PathVariable("typeId") int typeId) {
        ModelAndView mav = new ModelAndView("types/typesDetails");
        mav.addObject(this.types.findById(typeId));
        return mav;        
	}

}