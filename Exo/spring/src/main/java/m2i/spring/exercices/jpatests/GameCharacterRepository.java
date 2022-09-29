package m2i.spring.exercices.jpatests;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameCharacterRepository extends CrudRepository<GameCharacter,Long> {

	List<GameCharacter> findByPdvGreaterThanEqual(int pdv);
}
