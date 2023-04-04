package eshopWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduitController {

	@GetMapping("/produit")
	public String home() {
		return "produit/produit";
	}
}
