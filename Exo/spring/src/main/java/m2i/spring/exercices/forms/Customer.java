package m2i.spring.exercices.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	@NotNull
	@Size(min=2)
	private String name;
	
	@Min(0)
	private int number;
	
	
	public Customer(String name, int number) {
		this.name = name;
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public int getNumber() {
		return number;
	}

}
