package m2i.spring.exercices.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Exercice4ControllerForms {

	@GetMapping("/forms/exercice4")
	public String template(
			@RequestParam(defaultValue="Billy") String characterName ,
			@RequestParam(required=false) String characterClass,
			@RequestParam(required=false) String characterAge,
			Model model){
		model.addAttribute("characterName", characterName);
		model.addAttribute("characterClass", characterClass);
		model.addAttribute("characterAge", characterAge);
		
		
		return "exercices/forms/exercice4";
	}
}
