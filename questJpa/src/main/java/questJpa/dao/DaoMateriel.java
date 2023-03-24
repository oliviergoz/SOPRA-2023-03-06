package questJpa.dao;

import java.util.List;

import questJpa.entites.Materiel;
import questJpa.entites.Ordinateur;
import questJpa.entites.VideoProjecteur;

public interface DaoMateriel extends DaoGeneric<Materiel, String> {
	List<Ordinateur> findAllOrdinateur();
	List<VideoProjecteur> findAllVideoProjecteur();
}
