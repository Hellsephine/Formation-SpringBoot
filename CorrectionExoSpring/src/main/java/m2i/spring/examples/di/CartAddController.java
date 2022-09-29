package m2i.spring.examples.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartAddController {

	@Autowired
	private Cart cart;
	
	@GetMapping("/examples/di/cart-add")
	public String getCartAdd(Model model)
	{
		cart.addItem("Toto");
		
		return "/examples/di/cart-add";
	}
}
