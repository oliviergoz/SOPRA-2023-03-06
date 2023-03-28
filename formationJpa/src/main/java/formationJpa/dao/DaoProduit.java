package formationJpa.dao;

import java.util.List;

import formationJpa.entities.Produit;
import formationJpa.entities.heritage.deuxTables.Fournisseur;

public interface DaoProduit extends DaoGeneric<Produit, Long> {
	public List<Produit> findByLibelle(String libelle);

	public List<Produit> findByLibelleContaining(String libelle);

	public List<Produit> findByFournisseur(Fournisseur fournisseur);

	public long count();
}
