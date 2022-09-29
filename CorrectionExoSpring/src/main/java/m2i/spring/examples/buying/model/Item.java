package m2i.spring.examples.buying.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Item {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private Integer price;

	protected Item() {
	
	}
	
	public Item(Integer id, Integer price) {
		this.id = id;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
