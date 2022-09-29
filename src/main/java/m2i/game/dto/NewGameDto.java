package m2i.game.dto;


public class NewGameDto
{
	private int hero;
	
	private int[] items;
	
	private NewGameConsumableDto[] consumables;

	protected NewGameDto() {
	}

	public NewGameDto(int hero, int[] items, NewGameConsumableDto[] consumables) {
		this.hero = hero;
		this.items = items;
		this.consumables = consumables;
	}

	public int getHero() {
		return hero;
	}

	public int[] getItems() {
		return items;
	}

	public NewGameConsumableDto[] getConsumables() {
		return consumables;
	}
}
