package m2i.game.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Consumable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private String name;
	
	private int price;
	
	private int healedAmount;
	
	protected Consumable() {
	}

	public Consumable(String name, int price, int healedAmount) {
		this.name = name;
		this.price = price;
		this.healedAmount = healedAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealedAmount() {
		return healedAmount;
	}

	public void setHealedAmount(int healedAmount) {
		this.healedAmount = healedAmount;
	}

	public Integer getId() {
		return id;
	}
	
	public int getPrice()
	{
		return price;
	}

}
