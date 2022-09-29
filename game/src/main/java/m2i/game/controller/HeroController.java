package m2i.game.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import m2i.game.model.Hero;
import m2i.game.service.HeroServices;


@RestController
public class HeroController {

	@Autowired
	private HeroServices heroServices;
	
	@GetMapping("/api/heroes")
	public Iterable<Hero> getHeroes()
	{
		Iterable<Hero> heroes = heroServices.getHeroes();
		
		return heroes;
	}
	
	@GetMapping("/api/hero/{id}")
	public Hero getHero(@PathVariable final int id)
	{
		try
		{
			return heroServices.getHero(id);
		}
		catch (EntityNotFoundException e)
		{
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "Entity not found"
					);
		}
	}
}
