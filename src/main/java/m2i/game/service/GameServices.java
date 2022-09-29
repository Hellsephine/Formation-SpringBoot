package m2i.game.service;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.game.dto.NewGameDto;
import m2i.game.exception.ForbiddenException;
import m2i.game.model.Hero;
import m2i.game.model.Item;


/**
 * Le GameServices est un service haut niveau qui va orchestrer les autres services.
 * 
 * Il s'agit de la logique du jeu dans sa globalité.
 * 
 * A noter que ce service n'est pas lié à une entité particulière.
 */
@Service
public class GameServices {
	
	/**
	 * Les autres services qui seront utilisés par notre GameServices
	 */
	@Autowired
	private HeroServices heroServices;
	
	@Autowired
	private ItemServices itemServices;
	
	@Autowired
	private PlayerServices playerServices;
	
	/**
	 * A partir d'une entrée de l'utilisateur, nous allons créer une nouvelle partie.
	 * 
	 * L'utilisateur nous a fourni un Hero et une liste d'objets à acheter.
	 * 
	 * @param newGameDto L'objet envoyé par l'utilisateur décrivant la partie à créer.
	 * @throws EntityNotFoundException Si nous avons un identifiant sur une entité qui n'existe pas
	 * @throws ForbiddenException Si l'utilisateur tente de faire une opération interdite par les règles du jeu.
	 */
	public void createNewGame(NewGameDto newGameDto) throws EntityNotFoundException, ForbiddenException
	{
		// On récupère le héro à partir de son identifiant
		Hero hero = heroServices.getHero(newGameDto.getHero());
		
		// On récupère les articles à partir de leurs identifiants
		List<Item> items = Arrays
			.stream(newGameDto.getItems())
			.mapToObj(itemServices::getItem) // Programmation fonctionnelle, on pourrait faire un foreach
			.toList();
		
		// A partir du héro et des objets, on délègue à PlayerServices la création du personnage
		playerServices.createPlayer(hero, items);
	}
}
