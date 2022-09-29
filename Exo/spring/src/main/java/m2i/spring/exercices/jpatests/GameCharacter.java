package m2i.spring.exercices.jpatests;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameCharacter {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idLong;
	
	public String name;
	public int pdv;
	
	protected GameCharacter() {
		
	}
	
	public GameCharacter(String name, int pdv) {
		this.name = name;
		this.pdv = pdv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPdv() {
		return pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}

	public Long getIdLong() {
		return idLong;
	}
	
	
}
