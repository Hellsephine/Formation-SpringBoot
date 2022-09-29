package m2i.game.web.dto;

public class ItemDto {

	private String itemName;
	
	private int price;

	public ItemDto(String itemName, int price) {
		this.itemName = itemName;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setGold(int price) {
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}
}
