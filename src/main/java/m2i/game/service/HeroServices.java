package m2i.game.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.game.dao.HeroRepository;
import m2i.game.model.Hero;
import m2i.game.web.dto.HeroDto;


@Service
public class HeroServices {

	@Autowired
	private HeroRepository heroRepository;
	
	public void createHero(HeroDto heroDto)
	{
		Hero hero = new Hero(heroDto.getHeroName(), heroDto.getGold());
		heroRepository.save(hero);
	}
	
	public Iterable<Hero> getHeroes()
	{
		return heroRepository.findAll();
	}
	
	/**
	 * Récupère un Hero et envoie une exception si celui-ci n'existe pas.
	 * 
	 * @param heroId L'identifiant du héro à récupérer
	 * @return L'entité Hero correspondante
	 * @throws EntityNotFoundException Envoyée si le Hero n'existe pas
	 */
	public Hero getHero(int heroId) throws EntityNotFoundException
	{
		return ServiceUtils.getEntity(heroRepository, heroId);
	}
}
