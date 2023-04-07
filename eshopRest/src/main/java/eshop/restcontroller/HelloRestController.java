package eshop.restcontroller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/api/recupParam")
	public void recuperationParametre(@RequestParam String param) {
		System.out.println(param);
	}

	@GetMapping("/api/pathVariable/{prenom}")
	public void pathVariable(@PathVariable String prenom) {
		System.out.println(prenom);
	}

	@GetMapping("/api/pathVariable/{prenom}/detail")
	public void pathVariableDetail(@PathVariable String prenom) {
		System.out.println(prenom + " avec le detail");
	}

	// Post Put
	// curl -X POST -d '{"prenom":"olivier","nom":"gozlan"}' -H
	// "Content-Type:application/json" http://localhost:8080/eshop/api/personne

	@PostMapping("/api/personne")
	public void recupPersonne(@RequestBody Personne personne) {
		System.out.println(personne.getPrenom() + " " + personne.getNom());
	}
}
