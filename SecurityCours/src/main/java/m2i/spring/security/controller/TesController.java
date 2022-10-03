package m2i.spring.security.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import m2i.spring.security.dto.UserDto;

@RestController
public class TesController {

	@GetMapping("/test")
	public UserDto getHome(Principal principal)
	{
		return new UserDto("Toto", "Tata");
	}
}
