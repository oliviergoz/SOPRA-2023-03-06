package formationJpa.entities.heritage.uneTable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import formationJpa.entities.Adresse;

@DiscriminatorValue("supplier")
@Entity
public class FournisseurUneTable extends PersonneUneTable {
	@Column(name="supplier_contact")
	private String contact;

	public FournisseurUneTable() {

	}

	public FournisseurUneTable(String nom, Adresse adresse, String contact) {
		super(nom, adresse);
		this.contact = contact;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
