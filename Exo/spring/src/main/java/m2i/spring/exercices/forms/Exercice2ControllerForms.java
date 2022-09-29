package m2i.spring.exercices.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Exercice2ControllerForms {

	@GetMapping("/forms/exercice2")
	public String template(@RequestParam(defaultValue="Billy") String characterName ,@RequestParam(defaultValue="Larbin") String characterClass, Model model) {
		model.addAttribute("characterName", characterName);
		model.addAttribute("characterClass", characterClass);
		
		
		return "exercices/forms/exercice2";
	}
}
