package m2i.spring.exercices.templates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import m2i.spring.exercices.templates.model.Game;


@Controller
public class GameController {

	@GetMapping("/exercices/templates/game")
	public String getGame(Model model)
	{
		Game game = new Game("Toto", 2022, "Tata");
		model.addAttribute("game", game);
		
		return "templates/game";
	}
}
