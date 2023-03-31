package questJpa.dao;

import questJpa.entites.Formation;

public interface DaoFormation extends DaoGeneric<Formation, Long> {
	public Formation findByIdFetchModulesAndParticipant(Long id);
}
