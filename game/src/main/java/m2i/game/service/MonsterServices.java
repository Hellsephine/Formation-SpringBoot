package m2i.game.service;

import java.util.Random;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.game.dao.MonsterRepository;
import m2i.game.model.Monster;


@Service
public class MonsterServices {
	
	@Autowired
	private MonsterRepository monsterRepository;
	
	/**
	 * Récupère un Monster et envoie une exception si celui-ci n'existe pas.
	 * 
	 * @param monsterId L'identifiant de l'objet à récupérer
	 * @return L'entité Item correspondante
	 * @throws EntityNotFoundException Envoyée si le Monster n'existe pas
	 */
	public Monster getMonster(int monsterId) throws EntityNotFoundException
	{
		return ServiceUtils.getEntity(monsterRepository, monsterId);
	}
	
	/**
	 * Computes the damage done by this monster for this round.
	 * 
	 * @param monster
	 * @return
	 */
	public int computeDamage(Monster monster)
	{
		Random random = new Random();
		
		int monsterDamage = monster.getDamage();
		if (random.nextFloat() <= monster.getCriticalChance())
			monsterDamage *= 2;
		
		return monsterDamage;
	}
}
