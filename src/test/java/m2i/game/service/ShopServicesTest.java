package m2i.game.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import m2i.game.dao.ItemRepository;
import m2i.game.dao.PlayerRepository;
import m2i.game.model.Item;
import m2i.game.model.Player;

@SpringBootTest
public class ShopServicesTest {

	@Autowired
	private ShopServices shopServices;
	
	@MockBean
	private ItemRepository itemRepository;
	
	@MockBean
	private PlayerRepository playerReposity;

	@Test
	public void givenMissingPlayer_WhenBuying_ThenNotFoundException()
	{
		Optional<Player> emptyPlayer = Optional.empty();
		Mockito.when(playerReposity.findById(0)).thenReturn(emptyPlayer);
		
		Item item = Mockito.mock(Item.class);
		Mockito.when(itemRepository.findById(0)).thenReturn(Optional.of(item));
		
		assertThrows(EntityNotFoundException.class, () -> shopServices.Buy(0, 0));
	}
}
