package m2i.game.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.game.dao.ItemRepository;
import m2i.game.model.Item;
import m2i.game.web.dto.ItemDto;


/**
 * Le ItemServices s'occupe de créer et modifier l'entité Item.
 */
@Service
public class ItemServices {

	@Autowired
	private ItemRepository itemRepository;
	
	public void createItem(ItemDto itemDto)
	{
		Item item = new Item(itemDto.getItemName(), itemDto.getPrice());
		itemRepository.save(item);
	}
	
	/**
	 * Récupère un Item et envoie une exception si celui-ci n'existe pas.
	 * 
	 * @param itemId L'identifiant de l'objet à récupérer
	 * @return L'entité Item correspondante
	 * @throws EntityNotFoundException Envoyée si l'Item n'existe pas
	 */
	public Item getItem(int itemId) throws EntityNotFoundException
	{
		return ServiceUtils.getEntity(itemRepository, itemId);
	}
}
