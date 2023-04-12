package ajc.formation.soprasteria.eshop.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.soprasteria.eshop.entities.Fournisseur;
import ajc.formation.soprasteria.eshop.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	List<Produit> findByLibelle(String libelle);

	List<Produit> findByLibelleContaining(String libelle);

	@Query("update Produit p set p.fournisseur=null where p.fournisseur=:fournisseur")
	@Transactional
	@Modifying
	void setFournisseurToNullByFournisseur(@Param("fournisseur") Fournisseur fournisseur);

	@Transactional
	@Modifying
	void deleteByFournisseur(Fournisseur fournisseur);
}
