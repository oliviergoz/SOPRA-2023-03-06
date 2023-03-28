package formationJpa.dao;

import formationJpa.entities.heritage.deuxTables.Client;

public interface DaoClient extends DaoGeneric<Client, Long> {
	public Client findByIdfetchCommandefetchAchats(Long id);
}
