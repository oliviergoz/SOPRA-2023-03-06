package questJpa.entites;

import java.io.Serializable;
import java.util.Objects;

public class ModuleFormationId implements Serializable {
	private Formation formation;
	private Module module;

	public ModuleFormationId() {

	}

	public ModuleFormationId(Formation formation, Module module) {
		super();
		this.formation = formation;
		this.module = module;
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
		ModuleFormationId other = (ModuleFormationId) obj;
		return Objects.equals(formation, other.formation) && Objects.equals(module, other.module);
	}

}
