package m2i.spring.examples.transactional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import m2i.spring.examples.buying.exception.ForbiddenException;


/**
 * @Transactional
 * On peut mettre l'annotation sur la classe, cela signifie que toutes les méthodes
 * ont l'annotation.
 * 
 * (Peu recommandé, cela revient à refuser de réfléchir)
 */
@Service
public class TransactionalServices {

	@Autowired
	private TransactionalDataRepository dataRepository;
	
	@Autowired
	private TransactionalUserRepository userRepository;
	
	/**
	 * Insert en base de données sans transaction.
	 * 
	 * Les modifications seront persistés, même en cas d'exception.
	 * 
	 * Ici on peut insérer un user puis échouter sur l'insertion data, le user sera
	 * présent en base de données.
	 */
	public void UnsafeCreate(String email, int value)
	{
		TransactionalUser user = new TransactionalUser(email);
		TransactionalData data = new TransactionalData(value);
		
		userRepository.save(user);
		dataRepository.save(data);
	}
	
	/**
	 * La méthode va rollback si une exception est renvoyée par notre repository.
	 * 
	 * Peu élégant car le controlleur va devoir récupérer des exceptions techniques.
	 * 
	 * Si l'insertion de data échoue, le user ne sera pas inséré non plus.
	 */
	@Transactional
	public void Create(String email, int value)
	{
		TransactionalUser user = new TransactionalUser(email);
		TransactionalData data = new TransactionalData(value);
		
		// Ces deux méthodes peuvent renvoyer une exception pour violation de contrainte
		userRepository.save(user);
		dataRepository.save(data);
	} // L'exception est envoyée à la toute fin de la méthode, impossible de l'attraper dedans
	
	/**
	 * Exemple en encapsulant l'exception JPA pour en faire une exception plus
	 * compréhensible pour le controlleur.
	 * 
	 * On doit définir explicitement le type de l'exception via rollbackOn.
	 */
	@Transactional(rollbackOn = ForbiddenException.class)
	public void CreateRethrow(String email, int value) throws ForbiddenException
	{
		try
		{
			TransactionalUser user = new TransactionalUser(email);
			TransactionalData data = new TransactionalData(value);
			
			userRepository.save(user);
			dataRepository.save(data);
			
			// Force l'évaluation pour déclencher l'exception immédiatement
			userRepository.flush();
			dataRepository.flush();
		}
		catch (DataIntegrityViolationException e)
		{
			throw new ForbiddenException();
		}
	}
	
	/**
	 * Méthode pour récupérer le contenu de la BDD.
	 */
	public TransactionalDto GetAll()
	{ 
		return new TransactionalDto(userRepository.findAll(), dataRepository.findAll());
	}
}
