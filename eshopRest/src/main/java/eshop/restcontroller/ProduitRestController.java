package eshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.entities.Produit;
import eshop.entities.jsonviews.Exemple;
import eshop.entities.jsonviews.JsonViews;
import eshop.entities.jsonviews.ProduitWithFournisseur;
import eshop.entities.jsonviews.Simple;
import eshop.services.ProduitService;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {

	@Autowired
	private ProduitService produitSrv;

	@GetMapping("")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public List<Produit> getAll() {
		return produitSrv.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit getById(@PathVariable Long id) {
		return produitSrv.getById(id);
	}

	@PostMapping("")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produit create(@RequestBody Produit produit) {
		produitSrv.createOrUpdate(produit);
		return produitSrv.getById(produit.getId());
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit update(@RequestBody Produit produit, @PathVariable Long id) {
		Produit produitEnBase = produitSrv.getById(id);
		if (produit.getLibelle() != null) {
			produitEnBase.setLibelle(produit.getLibelle());
		}
		produitEnBase.setDescription(produit.getDescription());
		if (produit.getFournisseur() != null) {
			produitEnBase.setFournisseur(produit.getFournisseur());
		}
		if (produit.getPrix() >= 0.1) {
			produitEnBase.setPrix(produit.getPrix());
		}
		produitSrv.createOrUpdate(produitEnBase);
		return produitSrv.getById(produitEnBase.getId());
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		produitSrv.deleteById(id);
	}
}
