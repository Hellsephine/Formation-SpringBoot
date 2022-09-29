package m2i.spring.examples.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeanController {

	@Autowired
	private BeanB beanB;

	@GetMapping("/examples/beans")
	public String getSomething(Model model)
	{
		model.addAttribute("bean", beanB);
		
		return "/examples/beans/beans";
	}
}
