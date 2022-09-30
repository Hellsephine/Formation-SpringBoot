package m2i.spring.examples.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class JsonControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private JsonService jsonService;
	
	@Test
	public void whenCalled_thenReturnDefaultJson() throws Exception
	{
		/**
		 * Classe utilitaire de Jackson pour parser du json en chaîne de caractère
		 * et le transformer en objets Java
		 */
		ObjectMapper objectMapper = new ObjectMapper();
		
		/**
		 * La définition de la requête que l'on va exécuter :
		 *  
		 * - Méthode : POST/GET/DELETE/PUT (.get/.post...)
		 * - Paramètres de formulaire (.param)
		 * - Body (.content)
		 */
		MockHttpServletRequestBuilder query = MockMvcRequestBuilders
			.get("/examples/json");
		
		/**
		 * Exécute la requête préparée et récupère le résultat
		 */
		MvcResult result = mockMvc.perform(query).andReturn();
		
		// result.getResponse().getStatus() Contient 200/400/404/401/etc.
		
		/**
		 * Récupére le JSON renvoyé par le controller
		 */
		String returnedJsonStr = result.getResponse().getContentAsString();
		
		/**
		 * Transforme le JSON renvoyé en un objet Java (Jackson)
		 */
		JsonNode returnedJson = objectMapper.readTree(returnedJsonStr);
		
		/**
		 * Prépare le JSON que l'on souhaite récupérer
		 */
		String jsonStr = """
			{
				"someAttribute" : "someValue",
				"someValue" : 3
			}
		""";
		JsonNode expectedJson = objectMapper.readTree(jsonStr);
		
		assertEquals(expectedJson, returnedJson);
	}
	
	@Test
	public void whenPost_thenSaveBody() throws Exception
	{
		ObjectMapper objectMapper = new ObjectMapper();
		JsonDto jsonDto = new JsonDto("tata", 4);
		
		String body = objectMapper
			.valueToTree(jsonDto)
			.toPrettyString();
		
		MockHttpServletRequestBuilder query = MockMvcRequestBuilders
				.post("/examples/json")
				.contentType("application/json")
				.content(body);
		mockMvc.perform(query);
		
		/**
		 * Vérifie que la méthode "saveJson" est appelé sur le mock jsonService
		 * avec les bonnes données
		 * 
		 * Attention : bien définir la méthode Equals de JsonDto !
		 */
		Mockito.verify(jsonService).saveJson(jsonDto);
	}
	
	@Test
	public void givenCorrectBody_whenPost_thenReturn200() throws Exception
	{
		ObjectMapper objectMapper = new ObjectMapper();
		JsonDto jsonDto = new JsonDto("tata", 4);
		
		String body = objectMapper
			.valueToTree(jsonDto)
			.toPrettyString();
		
		MockHttpServletRequestBuilder query = MockMvcRequestBuilders
				.post("/examples/json")
				.contentType("application/json")
				.content(body);
		
		// Récupère le code HTTP renvoyé par le controlleur
		int status = mockMvc
				.perform(query)
				.andReturn()
				.getResponse()
				.getStatus();
		
		assertEquals(200, status);
	}
	
	@Test
	// @WithMockUser(roles = "USER") pour utiliser un utilisateur authentifié
	public void givenMissingBody_whenPost_thenReturn400() throws Exception
	{
		MockHttpServletRequestBuilder query = MockMvcRequestBuilders
				.post("/examples/json")
				.contentType("application/json");
		
		// Récupère le code HTTP renvoyé par le controlleur
		int status = mockMvc
				.perform(query)
				.andReturn()
				.getResponse()
				.getStatus();
		
		assertEquals(400, status);
	}
}
