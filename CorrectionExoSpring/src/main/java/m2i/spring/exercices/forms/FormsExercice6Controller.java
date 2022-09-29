package m2i.spring.exercices.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormsExercice6Controller {

	@GetMapping("/exercices/forms/exercice6")
	public String showFactoriel(@ModelAttribute("answer") String answer, Model model)
	{
		model.addAttribute("answer", answer);
		
		return "/forms/exercices/exercice6";
	}
	
	@PostMapping("/exercices/forms/exercice6")
	public String computeFactoriel(@RequestParam int number, RedirectAttributes redirectAttributes)
	{
		int result = MathUtils.computeFactoriel(number);
		
		redirectAttributes.addFlashAttribute("answer", result);
		
		return "redirect:/exercices/forms/exercice6";
	}
}
