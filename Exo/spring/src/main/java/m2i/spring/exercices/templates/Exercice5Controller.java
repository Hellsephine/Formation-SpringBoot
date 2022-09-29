package m2i.spring.exercices.templates;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exercice5Controller {
	@GetMapping("/templates/exercice5")
	public String template(Model model) {
		Game game = new Game(1996,"Pokemon_Version_Jaune","Game_Freak","Rpg");
		Player player = new Player("Pierre", game);
		
		model.addAttribute("player", player);
		
		
		return "exercices/templates/exercice5";
	}
}
