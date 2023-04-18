package ajc.formation.soprasteria.eshop.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.eshop.entities.Produit;
import ajc.formation.soprasteria.eshop.entities.jsonviews.JsonViews;
import ajc.formation.soprasteria.eshop.exceptions.ProduitException;
import ajc.formation.soprasteria.eshop.services.ProduitService;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin(origins = "*")
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
		Produit produit = null;
		try {
			produit = produitSrv.getById(id);
		} catch (ProduitException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return produit;
	}

	@PostMapping("")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produit create(@Valid @RequestBody Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
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
