package m2i.spring.examples.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;
	
	@PostMapping("/examples/jpa/player")
	public String postUser(@RequestParam("playerName") String playerName, RedirectAttributes redirectAttributes)
	{
		Player savedPlayer = playerRepository.save(new Player(playerName));
		
		redirectAttributes.addFlashAttribute("player", savedPlayer);
		
		return "redirect:/examples/jpa/player";
	}
	
	@GetMapping("/examples/jpa/player")
	public String getUser(@ModelAttribute("player") Player player, @ModelAttribute("initialPlayer") Player initialPlayer)
	{
		return "examples/jpa/player";
	}
}
