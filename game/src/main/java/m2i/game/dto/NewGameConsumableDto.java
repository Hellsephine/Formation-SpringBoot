package m2i.game.dto;

public class NewGameConsumableDto {
	
	private int id;
	
	private int quantity;
	
	protected NewGameConsumableDto()
	{
		
	}
	
	public NewGameConsumableDto(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public int getQuantity() {
		return quantity;
	}
	
}
