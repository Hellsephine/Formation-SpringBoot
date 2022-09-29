package m2i.spring.exercices.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Exercice5ControllerForms {

	@PostMapping("/forms/exercice5")
	public String template(
			@RequestParam String characterName,
			Model model){

		model.addAttribute("characterName", characterName);
		
		return "exercices/forms/exercice5-view";
	}
}