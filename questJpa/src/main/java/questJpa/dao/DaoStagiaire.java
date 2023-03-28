package questJpa.dao;

import java.util.List;

import questJpa.entites.Stagiaire;

public interface DaoStagiaire extends DaoGeneric<Stagiaire, Long> {
	public List<Stagiaire> findLessThan25year();
}
