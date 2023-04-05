package eshopWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.entities.Fournisseur;
import eshop.exceptions.FournisseurException;
import eshop.services.FournisseurService;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

	@Autowired
	private FournisseurService fournisseurSrv;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("fournisseurs", fournisseurSrv.getAll());
		return "fournisseur/fournisseur";
	}

	@GetMapping("/create")
	public String createFournisseur() {
		return "fournisseur/edition";
	}
	
	@GetMapping("/edit")
	public String editFournisseur(@RequestParam Long id,Model model) {
		Fournisseur fournisseur=fournisseurSrv.getById(id);
		model.addAttribute("fournisseur", fournisseur);
		return "fournisseur/edition";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		fournisseurSrv.deleteById(id);
		return "redirect:/fournisseur";
	}

//	@PostMapping("")
//	public String save(Model model, @RequestParam String nom, @RequestParam String contact) {
//		Fournisseur fournisseur = new Fournisseur(nom, null, contact);
//		model.addAttribute("fournisseur", fournisseur);
//		return "fournisseur/fournisseur";
//	}

	@PostMapping("")
	public String save(Model model, @ModelAttribute Fournisseur fournisseur) {
		try {
			fournisseurSrv.createOrUpdate(fournisseur);
		} catch (FournisseurException e) {
			model.addAttribute("error", true);
			return "fournisseur/edition";
		}
		return "redirect:/fournisseur";
	}
}
