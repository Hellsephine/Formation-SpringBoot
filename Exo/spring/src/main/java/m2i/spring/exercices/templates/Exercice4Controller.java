package m2i.spring.exercices.templates;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exercice4Controller {

	@GetMapping("/templates/exercice4")
	public String template(Model model) {
		Game game = new Game(1996,"Pokemon_Version_Jaune","Game_Freak","Rpg");
		model.addAttribute("game",game);
		
		
		return "exercices/templates/exercice4";
	}
	
}