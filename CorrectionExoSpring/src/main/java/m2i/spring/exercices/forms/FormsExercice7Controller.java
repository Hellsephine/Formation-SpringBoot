package m2i.spring.exercices.forms;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormsExercice7Controller {

	@GetMapping("/exercices/forms/exercice7-form")
	public String displayForm(Customer customer)
	{
		return "/forms/exercices/exercice7-form";
	}	
	
	@PostMapping("/exercices/forms/exercice7-form")
	public String processForm(@ModelAttribute("customer") @Valid Customer newCustomer, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
			return "/forms/exercices/exercice7-error";
		
		return "/forms/exercices/exercice7-success";
	}
}
