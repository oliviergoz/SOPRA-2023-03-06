package eshop.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.entities.Produit;
import eshop.exceptions.ProduitException;
import eshop.repositories.ProduitRepository;

//tous les traitements que je veux fournir pour les produits
@Service
public class ProduitService {

	@Autowired
	private Validator validator;

	@Autowired
	private ProduitRepository produitRepo;

	public List<Produit> getAll() {
		return produitRepo.findAll();
	}

	public Produit getById(Long id) {
		if (id == null) {
			throw new ProduitException("id obligatoire");
		}
		return produitRepo.findById(id).orElseThrow(() -> {
			throw new ProduitException("id inconnu");
		});
	}

	public void delete(Produit produit) {
		deleteById(produit.getId());
	}

	public void deleteById(Long id) {
		produitRepo.delete(getById(id));
	}

	// creation et mise a ensemble ou pas???
	public void createOrUpdate(Produit produit) {
//		if (produit.getLibelle() == null || produit.getLibelle().isBlank()) {
//			throw new ProduitException("libelle obligatoire");
//		}
//		if (produit.getPrix() <= 0) {
//			throw new ProduitException("probleme prix");
//		}

		Set<ConstraintViolation<Produit>> violations = validator.validate(produit);
		if (!violations.isEmpty()) {
			throw new ProduitException();
		}

		produitRepo.save(produit);
	}

	public List<Produit> getByLibelle(String libelle) {
		return produitRepo.findByLibelleContaining(libelle);
	}
}
