package eshop.entities;

import java.time.LocalDate;
import java.util.HashSet;
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
@Table(name = "shipping")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	@Column(name = "shipping_date")
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "shipping_id_customer", foreignKey = @ForeignKey(name = "shipping_id_customer_fk"))
	private Client client;

	// avec EmbeddedId
//	@OneToMany(mappedBy = "key.commande")
//	private Set<AchatAvecEmbeddedId> achats;
//	
//
//	public Set<AchatAvecEmbeddedId> getAchats() {
//		return achats;
//	}
//
//	public void setAchats(Set<AchatAvecEmbeddedId> achats) {
//		this.achats = achats;
//	}

	// IdClass
	@OneToMany(mappedBy = "commande")
	private Set<Achat> achats = new HashSet<>();

	public Set<Achat> getAchats() {
		return achats;
	}

	public void setAchats(Set<Achat> achats) {
		this.achats = achats;
	}

	public void addProduit(Produit produit, int quantite) {
		achats.add(new Achat(this, produit, quantite));
	}

	public Commande() {

	}

	public Commande(Client client) {
		this.client = client;
		date = LocalDate.now();
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		return Objects.equals(numero, other.numero);
	}

}
