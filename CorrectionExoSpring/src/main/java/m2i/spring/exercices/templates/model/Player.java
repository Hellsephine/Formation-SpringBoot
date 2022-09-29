package m2i.spring.exercices.templates.model;

public class Player {

	private String name;

	private Game game;
	
	public Player(String name, Game game) {
		super();
		this.name = name;
		this.game = game;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
