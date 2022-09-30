package m2i.spring.examples.controllertest;

import java.util.Objects;

public class JsonDto {

	private String someAttribute;
	
	private int someValue;
	
	protected JsonDto()
	{
		
	}

	
	public JsonDto(String someAttribute, int someValue) {
		super();
		this.someAttribute = someAttribute;
		this.someValue = someValue;
	}

	public String getSomeAttribute() {
		return someAttribute;
	}

	public int getSomeValue() {
		return someValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(someAttribute, someValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JsonDto other = (JsonDto) obj;
		return Objects.equals(someAttribute, other.someAttribute) && someValue == other.someValue;
	}
}
