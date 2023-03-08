package hospital.model;

import java.util.Objects;

public class Compte {
	private int id;
	private String login;
	private String password;
	private String typeCompte;
	private boolean connecte=false;
	
	
	public Compte() {
		
	}
	
	public Compte(int id, String login, String password, String typeCompte) {
		this.id=id;
		this.login=login;
		this.password=password;
		this.typeCompte=typeCompte;
	}
	
	
	public Compte(int id, String login, String password, boolean connecte) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.connecte = connecte;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public boolean isConnecte() {
		return connecte;
	}

	public void setConnecte(boolean connecte) {
		this.connecte = connecte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return id == other.id;
	}
	
	

}
