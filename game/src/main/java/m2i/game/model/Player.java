package m2i.game.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Player {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private int gold;
	
	private int health;
	
	@ManyToMany
	@JoinTable(name = "player_items",
			  joinColumns = @JoinColumn(name = "player_id"), 
			  inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items;

	protected Player() {
	
	}
	
	public Player(int health, Integer gold, List<Item> items) {
		this.health = health;
		this.gold = gold;
		this.items = items;
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
	
	public void addItem(Item item)
	{
		items.add(item);
	}
	
	public int getHealth() {
		return health;
	}
	
	/**
	 * Faire subir des dégâts au monstre
	 * 
	 * @param damage Le nombre de dégâts subits
	 * @return true si le monstre est encore en vie
	 */
	public boolean takeDamage(int damage)
	{
		this.health = Math.max(health - damage, 0);
		
		return health > 0;
	}
}
