package m2i.game.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.repository.CrudRepository;

public final class ServiceUtils {

	/**
	 * Récupère une entité et envoie une exception si celle-ci n'existe pas.
	 * 
	 * @param itemId L'identifiant de l'entité à récupérer
	 * @return L'entité l'entité correspondante
	 * @throws EntityNotFoundException Envoyée si l'entitée n'existe pas
	 */
	public static <T> T getEntity(CrudRepository<T, Integer> repository, int id)
	{
		Optional<T> optEntity = repository.findById(id);
		
		if (optEntity.isEmpty())
			throw new EntityNotFoundException();
		
		return optEntity.get();
	}
	
	private ServiceUtils()
	{
		
	}
}
