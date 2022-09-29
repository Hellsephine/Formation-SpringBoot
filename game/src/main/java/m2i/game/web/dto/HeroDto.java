package m2i.game.web.dto;

public class HeroDto {

	private String heroName;
	
	private int gold;

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getHeroName() {
		return heroName;
	}

	protected HeroDto(String heroName, int gold) {
		super();
		this.heroName = heroName;
		this.gold = gold;
	}
}
