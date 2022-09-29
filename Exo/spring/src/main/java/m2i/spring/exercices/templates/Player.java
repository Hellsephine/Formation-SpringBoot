package m2i.spring.exercices.templates;

public class Player{
	String playerName;
	Game game;
	
	public Player(String playerName, Game game) {
		this.playerName = playerName;
		this.game = game;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Game getGame() {
		return game;
	}
	
	
}