package m2i.spring.exercices.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Human {
	@NotNull
	@Size(min=2)
	private String name;
	
	@Min(3)
	@Max(6)
	private Integer number;
	
	@Min(-2)
	@Max(7)
	private Integer number1;
	
	@Min(8)
	@Max(11)
	private Integer number2;
	
	public Human(String name, Integer number, Integer number1, Integer number2){
		this.name = name;
		this.number = number;
		this.number1 = number1;
		this.number2 = number2;
	}

	public String getName() {
		return name;
	}

	public Integer getNumber() {
		return number;
	}

	public Integer getNumber1() {
		return number1;
	}

	public Integer getNumber2() {
		return number2;
	}

}
