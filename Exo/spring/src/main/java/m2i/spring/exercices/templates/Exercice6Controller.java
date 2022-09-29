package m2i.spring.exercices.templates;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exercice6Controller {
	@GetMapping("/templates/exercice6")
	public String template(Model model) {
		String[] film = {"John Wick","John Wick 2","John Wick 3"};
		model.addAttribute("film",film);
		
		return "exercices/templates/exercice6";
	}

}
