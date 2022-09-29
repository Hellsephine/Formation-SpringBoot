package m2i.game.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Monster {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private int health;

	private int damage;
	
	private float criticalChance;
	
	protected Monster()
	{
		
	}
	
	public Monster(int health, int damage, float critical)
	{
		
	}
	
	public Integer getId() {
		return id;
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

	public int getDamage() {
		return damage;
	}

	public float getCriticalChance() {
		return criticalChance;
	}
}
