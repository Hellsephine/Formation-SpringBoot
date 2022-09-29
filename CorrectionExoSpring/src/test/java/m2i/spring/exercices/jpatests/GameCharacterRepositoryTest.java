package m2i.spring.exercices.jpatests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
public class GameCharacterRepositoryTest {

	@Autowired
	private GameCharacterRepository gameCharacterRepository;
	
	@Test
	@Sql("given4HealthCharacter_WhenFindWithHealth_ThenCharacterIsNotReturned.sql")
	public void given4HealthCharacter_WhenFindWithHealth_ThenCharacterIsNotReturned()
	{
		List<GameCharacter> characters = gameCharacterRepository.findByHealthGreaterThanEqual(5);
		
		assertTrue(characters.isEmpty());
	}
}
