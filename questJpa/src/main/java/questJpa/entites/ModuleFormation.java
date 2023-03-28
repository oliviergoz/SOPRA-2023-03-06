package questJpa.entites;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "module_formation")
@IdClass(ModuleFormationId.class)
public class ModuleFormation {
	@Id
	@ManyToOne
	@JoinColumn(name = "module_formation_id_formation", foreignKey = @ForeignKey(name = "module_formation_id_formation_fk"))
	private Formation formation;
	@Id
	@ManyToOne
	@JoinColumn(name = "module_formation_id_module", foreignKey = @ForeignKey(name = "module_formation_id_module_fk"))
	private Module module;
	@ManyToOne
	@JoinColumn(name = "module_formation_animateur", foreignKey = @ForeignKey(name = "module_formation_animateur_fk"))
	private Formateur animateur;
	@Column(name = "module_formation_date")
	private LocalDate date;

	public ModuleFormation() {

	}

	public ModuleFormation(Formation formation, Module module, Formateur animateur, LocalDate date) {
		super();
		this.formation = formation;
		this.module = module;
		this.animateur = animateur;
		this.date = date;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Formateur getAnimateur() {
		return animateur;
	}

	public void setAnimateur(Formateur animateur) {
		this.animateur = animateur;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(formation, module);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleFormation other = (ModuleFormation) obj;
		return Objects.equals(formation, other.formation) && Objects.equals(module, other.module);
	}

}
