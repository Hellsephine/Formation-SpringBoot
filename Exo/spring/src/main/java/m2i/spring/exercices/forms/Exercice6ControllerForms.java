package m2i.spring.exercices.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Exercice6ControllerForms {
	
	@GetMapping("/exercices/forms/exercice6-view")
	public String templates(@ModelAttribute("answer") String answer,Model model){
		
		return "exercices/forms/exercice6-view";
	}

	@PostMapping("/forms/exercice6")
	public String template(@RequestParam int number,RedirectAttributes redirectAttributes){
		int f=1;
	    for(int i=2;i<=number;i++){ 
	    	f*= i;  
	    }  
		redirectAttributes.addFlashAttribute("answer", f);
		
		return "redirect:/exercices/forms/exercice6-view";
	}
}