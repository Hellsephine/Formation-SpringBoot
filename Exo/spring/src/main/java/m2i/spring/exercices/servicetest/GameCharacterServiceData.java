package m2i.spring.exercices.servicetest;

import m2i.spring.exercices.jpatests.GameCharacter;

public class GameCharacterServiceData {
	
	private int totalHealt;
	private int characterCount;
	private GameCharacter leader;
	
	public GameCharacterServiceData(int totalHealt, int characterCount, GameCharacter leader) {
		this.totalHealt = totalHealt;
		this.characterCount = characterCount;
		this.leader = leader;
	}

	public int getTotalHealt() {
		return totalHealt;
	}

	public int getCharacterCount() {
		return characterCount;
	}

	public GameCharacter getLeader() {
		return leader;
	}
}
