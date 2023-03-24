package formationJpa.dao;

import java.util.List;

import formationJpa.entities.heritage.uneTable.ClientUneTable;
import formationJpa.entities.heritage.uneTable.FournisseurUneTable;
import formationJpa.entities.heritage.uneTable.PersonneUneTable;

public interface DaoPersonneUneTable extends DaoGeneric<PersonneUneTable, Long> {
	List<ClientUneTable> findAllClient();

	List<FournisseurUneTable> findAllFournisseur();
}
