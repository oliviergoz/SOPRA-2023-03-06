package questJpa.entites;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("pc")
public class Ordinateur extends Materiel {

	@Column(name="ordinateur_processeur",length = 3)
	@Enumerated(EnumType.STRING)
	private Processeur processeur;
	@Column(name = "ordinateur_ram", length = 10)
	private String ram;

	public Ordinateur() {

	}

	public Ordinateur(String code, Processeur processeur, String ram) {
		super(code);
		this.processeur = processeur;
		this.ram = ram;
	}

	public Processeur getProcesseur() {
		return processeur;
	}

	public void setProcesseur(Processeur processeur) {
		this.processeur = processeur;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

}
