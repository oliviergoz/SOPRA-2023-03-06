package ajc.formation.soprasteria.eshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ajc.formation.soprasteria.eshop.entities.Produit;
import ajc.formation.soprasteria.eshop.exceptions.ProduitException;
import ajc.formation.soprasteria.eshop.services.FournisseurService;
import ajc.formation.soprasteria.eshop.services.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitSrv;
	@Autowired
	private FournisseurService fournisseurSrv;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("produits", produitSrv.getAll());
		return "produit/produit";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		produitSrv.deleteById(id);
		return "redirect:/produit";
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam Long id) {
		return goFormEdit(model, produitSrv.getById(id));
	}

	@GetMapping("/add")
	public String create(Model model) {
		return goFormEdit(model, new Produit());
	}

	private String goFormEdit(Model model, Produit produit) {
		model.addAttribute("fournisseurs", fournisseurSrv.getAll());
		model.addAttribute("produit", produit);
		return "produit/edit";
	}

	@PostMapping("")
	public String save(@Valid @ModelAttribute Produit produit,BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goFormEdit(model, produit);
		}
		
		if (produit.getFournisseur().getId() == null) {
			produit.setFournisseur(null);
		}
		try {
			produitSrv.createOrUpdate(produit);
		} catch (ProduitException e) {
			model.addAttribute("error", true);
			return goFormEdit(model, produit);
		}
		return "redirect:/produit";
	}
}
