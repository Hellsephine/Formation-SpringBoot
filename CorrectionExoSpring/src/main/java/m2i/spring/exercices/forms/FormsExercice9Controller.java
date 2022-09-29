package m2i.spring.exercices.forms;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormsExercice9Controller {

	@GetMapping("/forms/exercices/exercice9-form")
	public String getForm(Primer primer)
	{
		return "/forms/exercices/exercice9-form";
	}
	
	@PostMapping("/forms/exercices/exercice9-form")
	public String processForm(@Valid Primer primer, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
			return "/forms/exercices/exercice9-form";
			
		return "/forms/exercices/exercice9-success";
	}
}
