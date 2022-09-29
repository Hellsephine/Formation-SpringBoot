package m2i.spring.exercices.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import m2i.spring.exercices.jpatests.GameCharacter;
import m2i.spring.exercices.jpatests.GameCharacterRepository;

@SpringBootTest
public class GameCharacterServiceTest {

	@MockBean
	GameCharacterRepository gameCharacterRepository;

	@Autowired
	GameCharacterService gameCharacterService;
	
	@Test
	public void givenMockMethod_WhenMock_ThenMockReturnValue() {
		
		List<GameCharacter> ListOne = new ArrayList<GameCharacter>();
		
		
		Mockito.when(gameCharacterRepository.findByPdvGreaterThanEqual(5)).thenReturn(ListOne);
		assertTrue(gameCharacterService.Stats().getCharacterCount() == 0);
	}
	
	@Test
	public void givenMockMethod_WhenMock_ThenMockReturnValue2() {
		GameCharacter Two = new GameCharacter("Two",5);
		List<GameCharacter> ListTwo = new ArrayList<GameCharacter>();
		ListTwo.add(Two);
		
		Mockito.when(gameCharacterRepository.findByPdvGreaterThanEqual(5)).thenReturn(ListTwo);
		assertEquals(1,gameCharacterService.Stats().getCharacterCount());
		assertEquals(5,gameCharacterService.Stats().getTotalHealt());
		
	}
	
	
	@Test
	public void givenMockMethod_WhenMock_ThenMockReturnValue3() {
		GameCharacter Three = new GameCharacter("Three",5);
		GameCharacter Four = new GameCharacter("Four",6);
		List<GameCharacter> ListThree = new ArrayList<GameCharacter>();
		ListThree.add(Three);
		ListThree.add(Four);
		
		
		Mockito.when(gameCharacterRepository.findByPdvGreaterThanEqual(5)).thenReturn(ListThree);
		assertEquals(Four,gameCharacterService.Stats().getLeader());
		assertEquals(11,gameCharacterService.Stats().getTotalHealt());
		
	}
}	