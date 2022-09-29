package m2i.spring.examples.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartViewController {

	@Autowired
	private Cart cart;
	
	@GetMapping("/examples/di/cart-view")
	public String getCartView(Model model)
	{
		model.addAttribute("count", cart.itemCount());
		
		return "/examples/di/cart-view";
	}
}
