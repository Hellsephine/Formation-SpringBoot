package m2i.spring.exercices.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ExerciceDependencyController {
	
	@Autowired
	private Cart panier;
	
	@PostMapping("/exercices/dependency/exerciceDependency")
	public String postForm(
			@ModelAttribute Item item,
			RedirectAttributes redirectAttributes){
			panier.addItem(item);
			redirectAttributes.addFlashAttribute("item",item);
			return "redirect:/exercices/dependency/exerciceDependency";
	}
	
	@PostMapping("/exercices/dependency/exerciceDependency-reset")
	public String postView(){
			panier.removeAll();
			return "redirect:/exercices/dependency/exerciceDependency";
	}
			
	

	@GetMapping("/exercices/dependency/exerciceDependency-form")
	public String getForm(){
		
		return "/exercices/dependency/exerciceDependency-form";
	}
	
	@GetMapping("/exercices/dependency/exerciceDependency")
	public String getCart(Model model) {
		model.addAttribute("panier",panier);
		
		for(Item item : panier.getItems()) {
			System.out.println(item.getName());
		}
		
		
		return "/exercices/dependency/exerciceDependency";
		
		
	}
}
