package m2i.spring.examples.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import m2i.spring.examples.buying.exception.ForbiddenException;


@RestController
public class TransactionalController {

	@Autowired
	private TransactionalServices transactionalServices;
	
	/**
	 *  Devrait être un Post car nous insérons des données !
	 *  
	 *  Jet mets Get pour faciliter le test (pas besoin de formulaire ou de CURL).
	 */
	@GetMapping("/api/transactional/insert_unsafe")
	public TransactionalDto unsafeCreate(@RequestParam String email, @RequestParam int value)
	{	
		transactionalServices.UnsafeCreate(email, value);
	
		return transactionalServices.GetAll();
	}
	
	@GetMapping("/api/transactional/insert_safe")
	public TransactionalDto safeCreate(@RequestParam String email, @RequestParam int value)
	{	
		try
		{
			transactionalServices.Create(email, value);
		
			return transactionalServices.GetAll();
		}
		catch (DataIntegrityViolationException   e)
		{
			throw new ResponseStatusException(
					  HttpStatus.FORBIDDEN, "Forbidden"
					);
		}
	}
	
	@GetMapping("/api/transactional/insert_handle")
	public TransactionalDto handledCreate(@RequestParam String email, @RequestParam int value)
	{	
		try
		{
			transactionalServices.CreateRethrow(email, value);
		
			return transactionalServices.GetAll();
		}
		catch (ForbiddenException e)
		{
			throw new ResponseStatusException(
					  HttpStatus.FORBIDDEN, "Forbidden"
					);
		}
	}
	
	@GetMapping("/api/transactional/get")
	public TransactionalDto Get()
	{	
		return transactionalServices.GetAll();
	}
}
