package questJpa.entites;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "formateur")
@AttributeOverride(name = "id", column = @Column(name = "formateur_id"))
@AttributeOverride(name = "prenom", column = @Column(name = "formateur_prenom"))
@AttributeOverride(name = "nom", column = @Column(name = "formateur_nom", nullable = false))
@AttributeOverride(name = "mail", column = @Column(name = "formateur_mail"))
public class Formateur extends Personne {
	@Column(name = "formateur_interne")
	private boolean interne;

	public Formateur() {

	}

	public Formateur(String prenom, String nom, String mail, boolean interne) {
		super(prenom, nom, mail);
		this.interne = interne;
	}

	public boolean isInterne() {
		return interne;
	}

	public void setInterne(boolean interne) {
		this.interne = interne;
	}

}
