package m2i.game.web.dto;


public class ConsumableDto {

	private String name;
	
	private int price;
	
	private int healedAmount;

	public ConsumableDto(String name, int price, int healedAmount) {
		this.name = name;
		this.price = price;
		this.healedAmount = healedAmount;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
	
	public int getHealedAmount()
	{
		return healedAmount;
	}
}
