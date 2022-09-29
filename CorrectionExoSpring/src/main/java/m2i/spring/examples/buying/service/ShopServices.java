package m2i.spring.examples.buying.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.spring.examples.buying.dao.ItemRepository;
import m2i.spring.examples.buying.dao.PlayerRepository2;
import m2i.spring.examples.buying.exception.ForbiddenException;
import m2i.spring.examples.buying.model.Item;
import m2i.spring.examples.buying.model.Player2;

@Service
public class ShopServices {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private PlayerRepository2 playerReposity;
	
	public void Buy(int playerId, int itemId) throws EntityNotFoundException, ForbiddenException
	{
		Optional<Item> optItem = itemRepository.findById(itemId);
		Optional<Player2> optPlayer = playerReposity.findById(playerId);
		
		if (optItem.isEmpty() || optPlayer.isEmpty())
			throw new EntityNotFoundException();
		
		Item item = optItem.get();
		Player2 player = optPlayer.get();
		
		if (player.getGold() < item.getPrice())
			throw new ForbiddenException();
		
		player.setGold(player.getGold() - item.getPrice());
		playerReposity.save(player);
	}
}
