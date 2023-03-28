package questJpa.entites;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "formation")
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "formation_id")
	private Long id;
	@Column(name = "formation_nom")
	private String nom;
	@Column(name = "formation_date")
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "formation_id_referent", foreignKey = @ForeignKey(name = "formation_id_referent_fk"))
	private Formateur referent;
	@OneToMany(mappedBy = "formation")
	private Set<Stagiaire> participants;
	@OneToMany(mappedBy = "formation")
	private Set<ModuleFormation> modules;
	@ManyToOne
	@JoinColumn(name="formation_salle_id",foreignKey = @ForeignKey(name="formation_salle_id_fk"))
	private Salle salle;

	public Formation() {

	}

	public Formation(String nom, LocalDate date) {
		super();
		this.nom = nom;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Formateur getReferent() {
		return referent;
	}

	public void setReferent(Formateur referent) {
		this.referent = referent;
	}

	public Set<Stagiaire> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Stagiaire> participants) {
		this.participants = participants;
	}

	public Set<ModuleFormation> getModules() {
		return modules;
	}

	public void setModules(Set<ModuleFormation> modules) {
		this.modules = modules;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
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
		Formation other = (Formation) obj;
		return Objects.equals(id, other.id);
	}

}
