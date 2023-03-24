package questJpa.entites;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stagiaire")
@AttributeOverride(name = "id", column = @Column(name = "stagiaire_id"))
@AttributeOverride(name = "prenom", column = @Column(name = "stagiaire_prenom", nullable = false))
@AttributeOverride(name = "nom", column = @Column(name = "stagiaire_nom", nullable = false))
@AttributeOverride(name = "mail", column = @Column(name = "stagiaire_mail"))
public class Stagiaire extends Personne {
	@Column(name = "stagiaire_dt_naiss")
	private LocalDate dateNaissance;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "numero", column = @Column(name = "stagiaire_numero_rue", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "stagiaire_rue")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "stagiaire_cp", length = 50)),
			@AttributeOverride(name = "ville", column = @Column(name = "stagiaire_ville")) })
	private Adresse adresse;

	public Stagiaire() {

	}

	public Stagiaire(String prenom, String nom, String mail, LocalDate dateNaissance, Adresse adresse) {
		super(prenom, nom, mail);
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
