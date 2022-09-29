package m2i.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.game.dao.ConsumableRepository;
import m2i.game.model.Consumable;
import m2i.game.web.dto.ConsumableDto;

@Service
public class ConsumableServices {

	@Autowired
	private ConsumableRepository consumableRepository;
	
	public void createConsumable(ConsumableDto consumableDto)
	{
		Consumable consumable = new Consumable(
				consumableDto.getName(), 
				consumableDto.getPrice(), 
				consumableDto.getHealedAmount());
		
		consumableRepository.save(consumable);
	}
	
}
