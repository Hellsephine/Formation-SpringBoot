package m2i.spring.exercices.templates;

public class Game {
	
	int releaseYear;
	String gameName;
	String devStudio;
	String gender;
	
	public Game(int releaseYear, String gameName, String devStudio, String gender) {
		this.releaseYear = releaseYear;
		this.gameName = gameName;
		this.devStudio = devStudio;
		this.gender = gender;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public String getGameName() {
		return gameName;
	}

	public String getDevStudio() {
		return devStudio;
	}

	public String getGender() {
		return gender;
	}
	
	
	
}