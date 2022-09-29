package m2i.spring.exercices.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamsExo4Controller {

	
	@GetMapping("/forms/exercices/exo4")
	public String getExo4(Model model, @RequestParam String characterName, @RequestParam(required=false) String characterAge)
	{
		model.addAttribute("characterName", characterName);
		model.addAttribute("characterAge", characterAge);
		
		return "forms/exercices/exo4";
	}
}
