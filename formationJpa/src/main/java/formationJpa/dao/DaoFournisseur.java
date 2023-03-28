package formationJpa.dao;

import java.util.List;

import formationJpa.entities.heritage.deuxTables.Fournisseur;

public interface DaoFournisseur extends DaoGeneric<Fournisseur, Long> {
	public Fournisseur findByKeyFetchProduits(Long key);

	public List<Fournisseur> findAllFetchProduits();
}
