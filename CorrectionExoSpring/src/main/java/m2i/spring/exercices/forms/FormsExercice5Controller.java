package m2i.spring.exercices.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormsExercice5Controller {

	@GetMapping("/exercices/forms/exercice5")
	public String showCharacterName(@ModelAttribute("characterName") String characterName, Model model)
	{
		model.addAttribute("characterName", characterName);
		
		return "/forms/exercices/exercice5";
	}
	
	@PostMapping("/exercices/forms/exercice5")
	public String getCharacterName(@RequestParam String characterName, RedirectAttributes redirectAttributes)
	{
		redirectAttributes.addFlashAttribute("characterName", "Mr. " + characterName);
		
		return "redirect:/exercices/forms/exercice5";
	}
}
