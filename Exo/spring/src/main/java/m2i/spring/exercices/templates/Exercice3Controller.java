package m2i.spring.exercices.templates;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exercice3Controller {
	
	@GetMapping("/templates/exercice3")
	public String template(Model model) {
		model.addAttribute("number", "du dernier exercice");
		
		return "exercices/templates/exercice3";
	}
}