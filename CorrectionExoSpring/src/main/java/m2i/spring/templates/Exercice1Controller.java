package m2i.spring.templates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exercice1Controller {

	@GetMapping("/templates/exercice1")
	public String getTemplate()
	{
		return "templates/exercice1";
	}
}
