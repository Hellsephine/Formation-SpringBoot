package m2i.spring.exercices.forms;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Exercice7ControllerForms {
	
	@PostMapping("/forms/exercice7")
	public String template(
			@Valid Customer customer,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes){
			if (bindingResult.hasErrors())
				return "exercices/forms/exercice7-view-error";

			redirectAttributes.addFlashAttribute("customer", customer);
			return "redirect:/exercices/forms/exercice7-view";
	}
	
	@GetMapping("/exercices/forms/exercice7-view")
	public String templates(Model model){
		
		return "exercices/forms/exercice7-view";
	}

	
	
}
