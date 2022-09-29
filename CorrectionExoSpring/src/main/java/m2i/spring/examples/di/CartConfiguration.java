package m2i.spring.examples.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;


@Configuration
public class CartConfiguration {

	@Bean
	@SessionScope
	public Cart getCart()
	{
		return new Cart();
	}
}
