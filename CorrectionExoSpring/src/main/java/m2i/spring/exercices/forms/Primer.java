package m2i.spring.exercices.forms;

public class Primer {

	@IsPrime
	private Integer number;
	
	public Primer(Integer number)
	{
		this.number = number;
	}
	
	public Integer getNumber()
	{
		return number;
	}
}
