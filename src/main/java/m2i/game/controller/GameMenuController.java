package m2i.game.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import m2i.game.dto.NewGameDto;
import m2i.game.exception.ForbiddenException;
import m2i.game.service.GameServices;


@Controller
public class GameMenuController {

	@Autowired
	private GameServices gameServices;
	
	@GetMapping("game/pick-hero")
	public ModelAndView getGameMenu()
	{
		ModelAndView mv = new ModelAndView("game/pick-hero");
		
		return mv;
	}
	
	@GetMapping("game/pick-items")
	public ModelAndView getGameMenu(@RequestParam(name="hero") int heroId)
	{
		ModelAndView mv = new ModelAndView("game/pick-items");
		
		return mv;
	}
	
	/**
	 * Service appelé pour créer une nouvelle partie.
	 * 
	 * @param newGameDto Contient les informatins décrivant la nouvelle partie.
	 * @return TODO faire une redirection vers la partie lancée
	 */
	@PostMapping("/game/new")
	public ModelAndView startNewGame(@RequestBody NewGameDto newGameDto)
	{
		ModelAndView mv = new ModelAndView("game/game");
		
		try {
			gameServices.createNewGame(newGameDto);
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "Entity not found"
					);
		} catch (ForbiddenException e) {
			throw new ResponseStatusException(
					  HttpStatus.FORBIDDEN, "Forbidden"
					);
		}
		
		return mv;
	}
}
