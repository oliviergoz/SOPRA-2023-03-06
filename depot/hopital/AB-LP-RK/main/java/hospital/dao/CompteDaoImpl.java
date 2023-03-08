package hospital.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hospital.model.Compte;

public class CompteDaoImpl implements CompteDao {

	@Override
	public void insert(Compte obj) {
		PreparedStatement ps = null;
		try {
			ps = Context.getContext().getConnection().prepareStatement(" insert into compte(id,login,password,typeCompte) values(?,?,?,?)");
			ps.setInt(1, obj.getId());
			ps.setString(2, obj.getLogin());
			ps.setString(3, obj.getPassword());
			ps.setString(4, obj.getTypeCompte());	
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Context.close();
			Context.destroy();
		}
		
	}

	@Override
	public void update(Compte obj) {
		PreparedStatement ps =null;
		try {
			ps = Context.getContext().getConnection().prepareStatement("update compte set login=?,password=?,typeCompte=? where id=?");
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getTypeCompte());
			ps.setInt(4, obj.getId());
			ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			Context.close();
			Context.destroy();
		}		
	}

	@Override
	public void delete(Compte obj) {
		deleteByKey(obj.getId());
		
	}

	@Override
	public void deleteByKey(Integer key) {
		PreparedStatement ps = null;
		try {
			ps = Context.getContext().getConnection().prepareStatement("delete from compte where id=?");
			ps.setInt(1, key);
			ps.executeUpdate();			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Context.close();
			Context.destroy();
		}
		
	}

	@Override
	public Compte findByKey(Integer key) {
	Compte compte = null;
	PreparedStatement ps = null;
	try {
		ps = Context.getContext().getConnection().prepareStatement("select * from compte where id=?");
		ps.setInt(1, key);		
	}catch (SQLException e) {
	e.printStackTrace();
	}finally {
		Context.close();
		Context.destroy();
	}
		return compte;
	}

	@Override
	public List<Compte> findAll() {
	List<Compte> comptes = new ArrayList<>();
	Statement st = null;
	try {
		st = Context.getContext().getConnection().createStatement();
		ResultSet rs = st.executeQuery("select * from compte");
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		Context.close();
		Context.destroy();
	}
		return comptes;
	}

	
}
