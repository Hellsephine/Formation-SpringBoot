package m2i.spring.exercices.controllertests;

import org.springframework.stereotype.Service;

@Service
public class GameCharacterServices {

	public Army getArmy(String leaderName)
	{
		return new Army(15, 5, "Joe");
	}
	
	public void Save(String someData)
	{
		
	}
}
