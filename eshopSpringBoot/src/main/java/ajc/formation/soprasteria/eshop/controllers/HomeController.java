package ajc.formation.soprasteria.eshop.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("")
	public String home() {
		return "home";
	}
	
	@GetMapping("/page1")
	public String page1(HttpSession session) {
		session.setAttribute("login", "olivier");
		return "page1";
	}
	
	@GetMapping("/page2")
	public String page2() {
		return "page2";
	}
	
	@GetMapping("/closeSession")
	public String closeSession(HttpSession session) {
		session.invalidate();
		return "home";
	}
}
