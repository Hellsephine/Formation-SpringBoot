package m2i.spring.examples.buying.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import m2i.spring.examples.buying.dao.ItemRepository;
import m2i.spring.examples.buying.dao.PlayerRepository2;
import m2i.spring.examples.buying.model.Item;
import m2i.spring.examples.buying.model.Player2;

@SpringBootTest
public class ShopServicesTest {

	@Autowired
	private ShopServices shopServices;
	
	@MockBean
	private ItemRepository itemRepository;
	
	@MockBean
	private PlayerRepository2 playerReposity;

	@Test
	public void givenMissingPlayer_WhenBuying_ThenNotFoundException()
	{
		Optional<Player2> emptyPlayer = Optional.empty();
		Mockito.when(playerReposity.findById(0)).thenReturn(emptyPlayer);
		
		Item item = Mockito.mock(Item.class);
		Mockito.when(itemRepository.findById(0)).thenReturn(Optional.of(item));
		
		assertThrows(EntityNotFoundException.class, () -> shopServices.Buy(0, 0));
	}
}
