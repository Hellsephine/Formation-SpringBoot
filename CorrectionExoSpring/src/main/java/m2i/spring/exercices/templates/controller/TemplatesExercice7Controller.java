package m2i.spring.exercices.templates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import m2i.spring.exercices.templates.model.Game;

@Controller
public class TemplatesExercice7Controller {

	@GetMapping("/templates/exercices/games")
	public String getGames(Model model)
	{
		Game[] games = {
				new Game("Game 1", 2000, "Genre 1"), 
				new Game("Game 2", 3000, "Genre 2"),
				new Game("Game 3", 4000, "Genre 3")
			};
		
		model.addAttribute("games", games);
		
		return "templates/games";
	}
}
