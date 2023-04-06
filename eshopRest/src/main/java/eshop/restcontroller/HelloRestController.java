package eshop.restcontroller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.model.Adresse;
import eshop.model.Personne;

@RestController
public class HelloRestController {

	@GetMapping("/api/hello")
	public String sayHello() {
		return "hello world";
	}

	@GetMapping("/api/olivier")
	public Personne getOlivier() {
		Personne p = new Personne("olivier", "gozlan", new Adresse("chez olivier"));
		p.setTouteLesAdresses(Arrays.asList(new Adresse("adresse1"), new Adresse("adresse2")));
		return p;
	}
}
