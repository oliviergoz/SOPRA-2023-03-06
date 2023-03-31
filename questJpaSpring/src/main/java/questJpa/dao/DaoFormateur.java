package questJpa.dao;

import java.util.List;

import questJpa.entites.Formateur;

public interface DaoFormateur extends DaoGeneric<Formateur, Long> {
	public Formateur findByIdFetchFormationsEnTantQueReferent(Long id);

	public Formateur findByIdFetchModulesAnimes(Long id);

	public Formateur findByIdFetchFormationsEnTantQueReferentAndModulesAnimes(Long id);

	public List<Formateur> findAllInterne();

	public List<Formateur> findAllExterne();
}
