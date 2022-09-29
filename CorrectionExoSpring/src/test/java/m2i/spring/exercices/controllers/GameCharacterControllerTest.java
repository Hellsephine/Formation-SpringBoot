package m2i.spring.exercices.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import m2i.spring.exercices.controllertests.GameCharacterServices;


@SpringBootTest
@AutoConfigureMockMvc
public class GameCharacterControllerTest {

	@Autowired
	private MockMvc mvc;
			
	// Contient une méthode "save(String name")
	@MockBean
	private GameCharacterServices gameCharacterServices;

	@Test
	public void whenPostSave_ThenSaveServiceCalled() throws Exception {
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post("/exercices/controllertests/character")
				.param("name", "Joe");
		
		mvc.perform(request);

		Mockito.verify(gameCharacterServices).Save("Joe");
	}
}
