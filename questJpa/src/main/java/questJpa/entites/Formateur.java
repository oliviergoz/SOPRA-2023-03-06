package questJpa.entites;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy = "referent")
	private Set<Formation> formationsEnTantQueReferent;
	@OneToMany(mappedBy = "animateur")
	private Set<ModuleFormation> modulesAnimes;

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

	public Set<Formation> getFormationsEnTantQueReferent() {
		return formationsEnTantQueReferent;
	}

	public void setFormationsEnTantQueReferent(Set<Formation> formationsEnTantQueReferent) {
		this.formationsEnTantQueReferent = formationsEnTantQueReferent;
	}

	public Set<ModuleFormation> getModulesAnimes() {
		return modulesAnimes;
	}

	public void setModulesAnimes(Set<ModuleFormation> modulesAnimes) {
		this.modulesAnimes = modulesAnimes;
	}

}
