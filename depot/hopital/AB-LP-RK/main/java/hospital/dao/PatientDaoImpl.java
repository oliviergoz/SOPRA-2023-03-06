package hospital.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import hospital.model.Patient;

public class PatientDaoImpl implements PatientDao {

	@Override
	public void insert(Patient obj) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
	
		try {
			ps=Context.getContext().getConnection().prepareStatement("insert into patient(prenom,nom,id)values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getPrenom());
			ps.setString(2, obj.getNom());
			ps.setInt(3, obj.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Closer.close(ps);
			Context.destroy();
		}
		}
		
	

	@Override
	public void update(Patient obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Patient obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByKey(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Patient findByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> findAllPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
