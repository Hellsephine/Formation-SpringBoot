package m2i.spring.exercices.jpatests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;




@DataJpaTest
public class GameCharacterRepositoryTest{
	
	@Autowired
	private GameCharacterRepository gameCharacterRepository;
	
	@Test
	@Sql("givenPlayerWithNameAndHp_WhenFindByPdv_ShouldReturnPlayer.sql")
	public void givenPlayerWithNameAndHp_WhenFindByPdv_ShouldReturnPlayer() {
		List<GameCharacter> gameCharacters = gameCharacterRepository.findByPdvGreaterThanEqual(5);
		assertTrue(gameCharacters.isEmpty());
	}
	
	@Test
	@Sql("givenPlayerWithNameAndHp_WhenFindByHpEqualToFive_ShouldReturnPlayer.sql")
	public void givenPlayerWithNameAndHp_WhenFindByHpEqualToFive_ShouldReturnPlayer() {
		List<GameCharacter> gameCharacters = gameCharacterRepository.findByPdvGreaterThanEqual(5);
		assertFalse(gameCharacters.isEmpty());
	}
	
	@Test
	@Sql("givenPlayerWithNameAndHp_WhenFindByHpGreaterThanSix_ShouldReturnPlayer.sql")
	public void givenPlayerWithNameAndHp_WhenFindByHpGreaterThanSix_ShouldReturnPlayer() {
		List<GameCharacter> gameCharacters = gameCharacterRepository.findByPdvGreaterThanEqual(5);
		assertFalse(gameCharacters.isEmpty());
	}
	
	@Test
	@Sql("givenTenPlayer_WhenFindByHpGreaterThanEqual_ShouldReturnPlayer.sql")
	public void givenTenPlayer_WhenFindByHpGreaterThanEqual_ShouldReturnPlayer() {
		List<GameCharacter> gameCharacters = gameCharacterRepository.findByPdvGreaterThanEqual(5);
		assertThat(gameCharacters.size()).isEqualTo(10);
	}
}

