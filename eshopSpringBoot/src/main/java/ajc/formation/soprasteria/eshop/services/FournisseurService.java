package ajc.formation.soprasteria.eshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.eshop.entities.Fournisseur;
import ajc.formation.soprasteria.eshop.exceptions.FournisseurException;
import ajc.formation.soprasteria.eshop.repositories.FournisseurRepository;
import ajc.formation.soprasteria.eshop.repositories.ProduitRepository;

@Service
public class FournisseurService {

	@Autowired
	private FournisseurRepository fournisseurRepo;
	@Autowired
	private ProduitRepository produitRepo;

	public List<Fournisseur> getAll() {
		return fournisseurRepo.findAll();
	}

	public Fournisseur getById(Long id) {
		if (id == null) {
			throw new FournisseurException("id obligatoire");
		}
		return fournisseurRepo.findById(id).orElseThrow(() -> {
			throw new FournisseurException("id inconnu");
		});
	}

	public Fournisseur getByIdWithProduits(Long id) {
		if (id == null) {
			throw new FournisseurException("id obligatoire");
		}
		return fournisseurRepo.findByIdFetchProduits(id).orElseThrow(() -> {
			throw new FournisseurException("id inconnu");
		});
	}

	public void delete(Fournisseur fournisseur) {
		deleteById(fournisseur.getId());
	}

	public void deleteById(Long id) {
		Fournisseur f = getById(id);
		produitRepo.deleteByFournisseur(f);
		fournisseurRepo.deleteById(id);
	}

	public void createOrUpdate(Fournisseur fournisseur) {
		if (fournisseur.getNom() == null || fournisseur.getNom().isBlank()) {
			throw new FournisseurException("nom obligatoire");
		}
		if (fournisseur.getContact() == null || fournisseur.getContact().isBlank()) {
			throw new FournisseurException("contact obligatoire");
		}
		fournisseurRepo.save(fournisseur);
	}
}
