package m2i.spring.exercices.controllertests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameCharacterController {

	@Autowired
	private GameCharacterServices gameCharacterServices;
	
	@PostMapping("/exercices/controllertests/character")
	public void saveCharacter(@RequestParam String name)
	{
		gameCharacterServices.Save(name);
	}
}
