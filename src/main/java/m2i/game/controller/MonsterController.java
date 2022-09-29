package m2i.game.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import m2i.game.dto.AttackResultsDto;
import m2i.game.service.BattleServices;


@RestController
public class MonsterController {

	@Autowired
	private BattleServices battleServices;
	
	@PostMapping("/api/game/attack")
	public AttackResultsDto performAttack(@RequestParam int playerId, @RequestParam int monsterId)
	{
		try
		{
			return battleServices.Fight(playerId, monsterId);
		}
		catch (EntityNotFoundException e1)
		{
			throw new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "Entity not found"
				);
		}
	}
}
