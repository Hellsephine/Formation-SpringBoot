package m2i.spring.exercices.dependencyInjection;

public class Item {
	String name;
	float price;
	
	public Item(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrix(float price) {
		this.price = price;
	}
	
}
