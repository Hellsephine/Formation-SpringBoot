package m2i.game.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import m2i.game.service.ItemServices;
import m2i.game.web.dto.ItemDto;

@Controller
public class ItemAdminController {

	@Autowired
	private ItemServices itemServices;
	
	@PostMapping("/admin/item")
	public ModelAndView createItem(@ModelAttribute ItemDto itemDto)
	{
		itemServices.createItem(itemDto);
		
		// Une classe qui contient l'URL du template et les attributs pour Thymeleaf
		ModelAndView mv = new ModelAndView("/admin/success");
		
		return mv;
	}
}
