package m2i.game.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import m2i.game.service.HeroServices;
import m2i.game.web.dto.HeroDto;

@Controller
public class HeroAdminController {

	@Autowired
	private HeroServices heroServices;
	
	@PostMapping("/admin/hero")
	public ModelAndView createHero(@ModelAttribute HeroDto hero)
	{
		heroServices.createHero(hero);
		
		// Une classe qui contient l'URL du template et les attributs pour Thymeleaf
		ModelAndView mv = new ModelAndView("/admin/success");
		
		return mv;
	}
}
