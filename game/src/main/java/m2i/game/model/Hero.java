package m2i.game.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Hero {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private int gold; // or de départ
	
	private String name; // nom de la classe du héro
	
	protected Hero() {
	
	}
	
	public Hero(String name, Integer gold) {
		this.name = name;
		this.gold = gold;
	}

	public Integer getId() {
		return id;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}
	
	public String getName() {
		return name;
	}
}
