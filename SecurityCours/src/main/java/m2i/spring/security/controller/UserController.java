package m2i.spring.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import m2i.spring.security.dto.UserDto;
import m2i.spring.security.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public String registerUser(@Valid UserDto user, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
			return "/register";
		
		userService.createUser(user);
		
		return "redirect:/login";
	}
	
	@GetMapping("/register")
	public String getForm(Model model)
	{
		model.addAttribute("user", new UserDto("", ""));
		
		return "/register";
	}
}
