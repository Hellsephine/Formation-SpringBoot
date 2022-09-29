package m2i.game.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.game.dao.PlayerRepository;
import m2i.game.exception.ForbiddenException;
import m2i.game.model.Hero;
import m2i.game.model.Item;
import m2i.game.model.Player;

/**
 * Le PlayerServices s'occupe de créer et modifier l'entité Player.
 */
@Service
public class PlayerServices {

	@Autowired
	private PlayerRepository playerRepository;
	
	/**
	 * Créer un joueur à partir d'un archétype de héro et d'une liste d'articles.
	 * 
	 * @param hero Le héro qui sert de base pour le personnage.
	 * @param items Les articles à acheter.
	 * @return Le joueur créé.
	 * @throws ForbiddenException Renvoyé si le héro n'a pas assez d'or.
	 */
	public Player createPlayer(Hero hero, List<Item> items) throws ForbiddenException
	{
		// Nous allons vérifier si le joueur a asssez d'or pour acheter les objets
		int currentGold = hero.getGold(); // Or de départ
		for (Item item : items)
			currentGold -= item.getPrice(); // On retire le prix de chaque article
		
		if (currentGold < 0) // Si l'or est négatif, nous n'avions pas assez !
			throw new ForbiddenException(); // Exception pour informer le controlleur
		
		// Si on arrive ici, tout est OK, on peut créer le joueur
		Player player = new Player(100, currentGold, items);
		playerRepository.save(player);
		
		return player;
	}
	
	/**
	 * Récupère un Player et envoie une exception si celui-ci n'existe pas.
	 * 
	 * @param playerId L'identifiant du joueur à récupérer
	 * @return L'entité Hero correspondante
	 * @throws EntityNotFoundException Envoyée si le Player n'existe pas
	 */
	public Player getPlayer(int playerId) throws EntityNotFoundException
	{
		return ServiceUtils.getEntity(playerRepository, playerId);
	}
}
