package m2i.spring.exercices.forms;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Exercice8ControllerForms {
	@PostMapping("/forms/exercice8")
	public String template(
			@Valid Human human,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes){
			if (bindingResult.hasErrors())
				return "exercices/forms/exercice8-form";

			redirectAttributes.addFlashAttribute("human",human);
			return "redirect:/exercices/forms/exercice8-view";
	}
	
	@GetMapping("/exercices/forms/exercice8-view")
	public String templates(Model model){
		
		return "/exercices/forms/exercice8-view";
	}

	@GetMapping("/exercices/forms/exercice8-form")
	public String templates(Human human){
		
		return "/exercices/forms/exercice8-form";
	}
}
