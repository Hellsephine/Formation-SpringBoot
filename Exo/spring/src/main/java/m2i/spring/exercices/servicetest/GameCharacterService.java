package m2i.spring.exercices.servicetest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.spring.exercices.jpatests.GameCharacter;
import m2i.spring.exercices.jpatests.GameCharacterRepository;

@Service
public class GameCharacterService {
	
	@Autowired
	GameCharacterRepository gameCharacterRepository;
	
	
	public GameCharacterServiceData Stats() {
		
		
		List<GameCharacter> result = gameCharacterRepository.findByPdvGreaterThanEqual(5);
		
		int totalHealth = 0;
		for (int i=0;i<result.size();i++)
			totalHealth += result.get(i).getPdv();
			
		int characterCount = result.size();
			if(result.size()<= 0) {
				GameCharacterServiceData Data = new GameCharacterServiceData(0,0,null);
				return Data;
			}
		
		GameCharacter leader = result.get(0);
		for (int i=1;i<result.size();i++) {
			if(result.get(i).getPdv() > leader.getPdv())
				leader = result.get(i);
		}
		GameCharacterServiceData Data = new GameCharacterServiceData(totalHealth,characterCount, leader);
		return Data;
	}

}