package m2i.game.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.game.dao.ConsumableRepository;
import m2i.game.dao.ItemRepository;
import m2i.game.dao.PlayerConsumableRepository;
import m2i.game.dao.PlayerRepository;
import m2i.game.exception.ForbiddenException;
import m2i.game.model.Consumable;
import m2i.game.model.Item;
import m2i.game.model.Player;
import m2i.game.model.PlayerConsumable;
import m2i.game.model.PlayerConsumableId;


@Service
public class ShopServices {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private PlayerRepository playerReposity;
	
	@Autowired
	private ConsumableRepository consumableReposity;

	@Autowired
	private PlayerConsumableRepository playerConsumableReposity;
	
	/**
	 * On essaie d'acheter un objet pour l'ajouter à l'inventaire du joueur.
	 * 
	 * @param playerId L'identifiant du joueur
	 * @param itemId L'identifiant de l'objet
	 * @throws EntityNotFoundException Exception si les entités n'existent pas
	 * @throws ForbiddenException Exception si le joueur n'a pas assez d'or
	 */
	public void Buy(int playerId, int itemId) throws EntityNotFoundException, ForbiddenException
	{
		// On essaie de retrouver les entités
		Optional<Item> optItem = itemRepository.findById(itemId);
		Optional<Player> optPlayer = playerReposity.findById(playerId);
		
		// Si il en manque une, on envoie une exception
		if (optItem.isEmpty() || optPlayer.isEmpty())
			throw new EntityNotFoundException();
		
		// On récupère les entités à partir des Optional
		Item item = optItem.get();
		Player player = optPlayer.get();
		
		// Si le joueur n'a pas assez d'or, on envoie une exception
		if (player.getGold() < item.getPrice())
			throw new ForbiddenException();
		
		// On fait payer le joueur
		player.setGold(player.getGold() - item.getPrice());
		// On ajoute l'objet au joueur
		player.addItem(item);
		
		// On sauvegarde les modifications
		playerReposity.save(player);
	}
	
	/**
	 * On ajoute un consommable au joueur.
	 * 
	 * @param playerId L'identifiant du joueur
	 * @param consumableId L'identifiant du consommable
	 * @throws EntityNotFoundException Envoyée si une des entités n'existe pas.
	 */
	public void Add(int playerId, int consumableId) throws EntityNotFoundException
	{
		// On récupère la ligne qui contient l'association player<->consumable
		PlayerConsumableId id = new PlayerConsumableId(playerId, consumableId);
		Optional<PlayerConsumable> optPlayerConsumable = playerConsumableReposity.findById(id);
		
		PlayerConsumable playerConsumable;
		
		// On teste si l'association existe déjà
		if (optPlayerConsumable.isEmpty())
		{
			// Si non, on crée l'association avec une quantité initiale de 1
			Player player = playerReposity.getReferenceById(playerId);
			Consumable consumable = consumableReposity.getReferenceById(consumableId);
			
			playerConsumable = new PlayerConsumable(player, consumable, 1);
		}
		else
		{
			// Si elle existe déjà, on augmente la quantité de un
			playerConsumable = optPlayerConsumable.get();
			playerConsumable.setQuantity(playerConsumable.getQuantity() + 1);
		}
		
		// Dans tous les cas, on sauvegarde l'association
		playerConsumableReposity.save(playerConsumable);
	}
}
