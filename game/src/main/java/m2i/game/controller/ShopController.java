package m2i.game.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import m2i.game.exception.ForbiddenException;
import m2i.game.service.ShopServices;


@RestController
public class ShopController {

	@Autowired
	private ShopServices shopServices;
	
	@PostMapping("/api/shop")
	public ResponseEntity<String> buyItem(@RequestParam int playerId, @RequestParam int itemId)
	{
		try
		{
			shopServices.Buy(playerId, itemId);
			
			return ResponseEntity.ok().build();
			// Success
		}
		catch (EntityNotFoundException e1)
		{
			throw new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "Entity not found"
				);
		}
		catch (ForbiddenException e2)
		{
			throw new ResponseStatusException(
					  HttpStatus.BAD_REQUEST, "Forbidden"
					);
		}
	}
}
