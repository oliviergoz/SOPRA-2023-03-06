package ajc.formation.soprasteria.eshop.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ajc.formation.soprasteria.eshop.services.CompteService;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins = "*")
public class CompteRestController {

	@Autowired
	private CompteService compteSrv;
	
	@GetMapping("/login/check/{login}")
	public boolean loginExist(@PathVariable String login) {
		return compteSrv.loginExist(login);
	}
}
