package m2i.game.dto;

public class AttackResultsDto {

	private int mobHealth;
	
	private int playerHealth;
	
	private int mobAttack;
	
	private int playerAttack;
	
	private int goldReward;
	
	protected AttackResultsDto()
	{
		
	}

	public AttackResultsDto(int mobHealth, int playerHealth, int mobAttack, int playerAttack, int goldReward) {
		super();
		this.mobHealth = mobHealth;
		this.playerHealth = playerHealth;
		this.mobAttack = mobAttack;
		this.playerAttack = playerAttack;
		this.goldReward = goldReward;
	}

	public int getMobHealth() {
		return mobHealth;
	}

	public int getPlayerHealth() {
		return playerHealth;
	}

	public int getMobAttack() {
		return mobAttack;
	}

	public int getPlayerAttack() {
		return playerAttack;
	}

	public int getGoldReward() {
		return goldReward;
	}
	
	
}
