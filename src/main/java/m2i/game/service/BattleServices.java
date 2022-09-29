package m2i.game.service;

import java.util.Random;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.game.dto.AttackResultsDto;
import m2i.game.model.Monster;
import m2i.game.model.Player;

@Service
public class BattleServices {

	@Autowired
	private PlayerServices playerServices;
	
	@Autowired
	private MonsterServices monsterServices;
	
	public AttackResultsDto Fight(int playerId, int monsterId) throws EntityNotFoundException
	{
		Player player = playerServices.getPlayer(playerId);
		Monster monster = monsterServices.getMonster(monsterId);
		int monsterDamage = 0;
		int goldReward = 0;
		
		Random random = new Random();
		
		/**
		 * Attaque du joueur
		 */
		boolean monsterIsAlive = monster.takeDamage(10);
		
		if (monsterIsAlive) {
			/**
			 * Attaque du monstre
			 */
			monsterDamage = monsterServices.computeDamage(monster);
			boolean playerIsAlive = player.takeDamage(monsterDamage);
			
			if (playerIsAlive)
			{
				// Game over
			}
		}
		else {
			goldReward = random.nextInt(10, 20);
		}
		
		return new AttackResultsDto(
				monster.getHealth(),
				player.getHealth(),
				10,
				monsterDamage,
				goldReward
				);
		
	}
}
