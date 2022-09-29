package m2i.spring.exercices.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Customer {

	@Size(min=2, max=30)
	private String name;
	
	@Min(0)
	@Max(30)
	private Integer age;
	
	protected Customer()
	{
		
	}
	
	public Customer(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
}
