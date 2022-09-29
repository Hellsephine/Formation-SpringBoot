package m2i.spring.exercices.templates.model;

public class Game {

	private String name;
	
	private int year;
	
	private String genre;
	
	public Game(String name, int year, String genre) {
		this.name = name;
		this.year = year;
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
