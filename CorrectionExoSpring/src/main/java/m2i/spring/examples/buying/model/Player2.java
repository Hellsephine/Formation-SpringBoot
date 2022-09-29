package m2i.spring.examples.buying.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Player2 {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private Integer gold;

	protected Player2() {
	
	}
	
	public Player2(Integer id, Integer gold) {
		this.id = id;
		this.gold = gold;
	}

	public Integer getId() {
		return id;
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}
}
