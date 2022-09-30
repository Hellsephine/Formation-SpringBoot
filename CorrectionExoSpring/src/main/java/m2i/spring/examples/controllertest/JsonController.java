package m2i.spring.examples.controllertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

	@Autowired
	private JsonService jsonService;
	
	@GetMapping("/examples/json")
	public JsonDto getJson()
	{
		return new JsonDto("someValue", 3);
	}
	
	@PostMapping("/examples/json")
	public ResponseEntity<String> setJson(@RequestBody JsonDto someParam)
	{
		jsonService.saveJson(someParam);
		
		return ResponseEntity
				.ok()
				.build();
	}
}
