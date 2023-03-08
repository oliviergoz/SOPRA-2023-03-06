package hospital.dao;

import java.util.List;

import hospital.model.Patient;

public interface PatientDao extends DaoGeneric<Patient,String> {

	List<Patient> findAllPatient();
}
