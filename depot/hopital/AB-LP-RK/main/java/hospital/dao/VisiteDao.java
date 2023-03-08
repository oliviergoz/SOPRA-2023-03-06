package hospital.dao;

import hospital.model.Visite;

public interface VisiteDao extends DaoGeneric<Visite,String> {

	List<Visite> findAllVisite();
}
