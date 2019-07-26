package br.com.dbserver.samples.sensorumidade.read;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ReadController {

	private final ReadRepository reads;
	
	
	public ReadController(ReadRepository reads) {
		super();
		this.reads = reads;
	
	}

	@GetMapping("/reads")
	public String processFindForm(Model model) {
		Collection<Read> readsList = reads.findAll();
		model.addAttribute("reads", readsList);
		return "reads/readsList";
	}
		
	@GetMapping("/reads/{readId}")
	public ModelAndView showRead(@PathVariable("readId") int readId) {
        ModelAndView mav = new ModelAndView("reads/readsDetails");
        mav.addObject(this.reads.findById(readId));
        return mav;		
	}
	
}
