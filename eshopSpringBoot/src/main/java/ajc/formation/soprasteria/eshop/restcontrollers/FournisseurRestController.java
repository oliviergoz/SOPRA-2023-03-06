package ajc.formation.soprasteria.eshop.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import ajc.formation.soprasteria.eshop.entities.Fournisseur;
import ajc.formation.soprasteria.eshop.entities.jsonviews.JsonViews;
import ajc.formation.soprasteria.eshop.services.FournisseurService;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurRestController {
	@Autowired
	private FournisseurService fournisseurSrv;

	@GetMapping("")
	@JsonView(JsonViews.Fournisseur.class)
	public List<Fournisseur> getAll() {
		return fournisseurSrv.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Fournisseur.class)
	public Fournisseur getById(@PathVariable Long id) {
		Fournisseur fournisseur = null;
		fournisseur = fournisseurSrv.getById(id);
		return fournisseur;
	}

	@GetMapping("/{id}/produits")
	@JsonView(JsonViews.FournisseurWithProduits.class)
	public Fournisseur getByIdWithProduits(@PathVariable Long id) {
		Fournisseur fournisseur = null;
		fournisseur = fournisseurSrv.getByIdWithProduits(id);
		return fournisseur;
	}

	@PostMapping("")
	@JsonView(JsonViews.Fournisseur.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Fournisseur create(@Valid @RequestBody Fournisseur fournisseur, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		fournisseurSrv.createOrUpdate(fournisseur);
		return fournisseur;
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Fournisseur.class)
	public Fournisseur update(@RequestBody Fournisseur fournisseur, @PathVariable Long id) {
		Fournisseur fournisseurEnBase = fournisseurSrv.getById(id);
		if (fournisseur.getNom() != null) {
			fournisseurEnBase.setNom(fournisseur.getNom());
		}
		if (fournisseur.getAdresse() != null) {
			fournisseurEnBase.setAdresse(fournisseur.getAdresse());
		}
		fournisseurEnBase.setContact(fournisseur.getContact());
		fournisseurSrv.createOrUpdate(fournisseurEnBase);
		return fournisseurEnBase;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		fournisseurSrv.deleteById(id);
	}
}
