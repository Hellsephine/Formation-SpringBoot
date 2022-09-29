package m2i.spring.examples.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;


@Configuration
public class BeansConfiguration {

	@Bean
	@SessionScope
	public BeanA getBeanA()
	{
		return new BeanA("Injecté");
	}
	
	@Bean
	@RequestScope
	public BeanB getBeanB(BeanA beanA)
	{
		return new BeanB(beanA);
	}
}
