package m2i.game.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import m2i.game.service.ConsumableServices;
import m2i.game.web.dto.ConsumableDto;

@Controller
public class ConsumableAdminController {

	@Autowired
	private ConsumableServices consumableServices;
	
	@PostMapping("/admin/consumable")
	public ModelAndView createConsumable(@ModelAttribute ConsumableDto consumableDto)
	{
		consumableServices.createConsumable(consumableDto);
		
		// Une classe qui contient l'URL du template et les attributs pour Thymeleaf
		ModelAndView mv = new ModelAndView("/admin/success");
		
		return mv;
	}
}
