package m2i.spring.exercices.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Exercice1ControllerForms {

	@GetMapping("/forms/exercice1")
	public String template(@RequestParam String characterName, Model model) {
		model.addAttribute("characterName", characterName);
		
		
		return "exercices/forms/exercice1";
	}
}
