package ajc.formation.soprasteria.eshop.restcontrollers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.eshop.entities.Compte;
import ajc.formation.soprasteria.eshop.entities.jsonviews.JsonViews;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthenticationRestController {

	@GetMapping("")
	@JsonView(JsonViews.Compte.class)
	public Compte authentication(@AuthenticationPrincipal Compte compte){
		return compte;
	}
	
}
