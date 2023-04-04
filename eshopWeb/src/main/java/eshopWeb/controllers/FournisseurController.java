package eshopWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

	@GetMapping("")
	public String home() {
		return "fournisseur/fournisseur";
	}

	@GetMapping("/edit")
	public String editionFournisseur() {
		return "fournisseur/edition";
	}

	@GetMapping("/delete")
	public String delete() {
		return "";
	}
}
