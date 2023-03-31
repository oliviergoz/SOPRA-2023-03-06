package eshop.dao;

import java.util.List;

import eshop.entities.Fournisseur;

public interface DaoFournisseur extends DaoGeneric<Fournisseur, Long> {
	public Fournisseur findByKeyFetchProduits(Long key);

	public List<Fournisseur> findAllFetchProduits();
}
