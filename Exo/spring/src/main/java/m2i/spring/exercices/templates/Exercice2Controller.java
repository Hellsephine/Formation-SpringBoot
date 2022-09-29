package m2i.spring.exercices.templates;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exercice2Controller {

	@GetMapping("/templates/exercice2")
	public String template() {
		return "exercices/templates/exercice2";
	}
}