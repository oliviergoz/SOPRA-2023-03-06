package eshop.dao;

import java.util.List;

import eshop.entities.Fournisseur;
import eshop.entities.Produit;

public interface DaoProduit extends DaoGeneric<Produit, Long> {
	public List<Produit> findByLibelle(String libelle);

	public List<Produit> findByLibelleContaining(String libelle);

	public List<Produit> findByFournisseur(Fournisseur fournisseur);

	public long count();

	public void deleteByFournisseur(Fournisseur fournisseur);
	
	public void setFournisseurToNullByFournisseur(Fournisseur fournisseur) ;
}
