package m2i.spring.exercices.templates;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exercice7Controller {

	@GetMapping("/templates/exercice7")
	public String template(Model model) {
		Game[] game = {
				new Game(2000,"Fire Emblem","Intelligent Systems","Rpg"),
				new Game(2001, "Pokemon", "GameFreak", "Rpg"),
				new Game(2002, "DarkSouls", "FromSoftware", "Die&Retry")
				};
		model.addAttribute("game",game);
		
		return "exercices/templates/exercice7";
		
	}
}