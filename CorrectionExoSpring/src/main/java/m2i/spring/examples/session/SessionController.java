package m2i.spring.examples.session;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

	
	@GetMapping("/examples/sessionA")
	public String getSessionA(HttpSession session)
	{
		session.setAttribute("value", 3);
		
		return "/examples/session/sessionA";
	}
	
	@GetMapping("/examples/sessionB")
	public String getSessionB()
	{
		return "/examples/session/sessionB";
	}
}
