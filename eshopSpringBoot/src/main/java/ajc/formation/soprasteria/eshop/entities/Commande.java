package ajc.formation.soprasteria.eshop.entities;

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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.eshop.entities.jsonviews.JsonViews;

@Entity
@Table(name = "shipping")

public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Simple.class)
	private Long numero;
	@Column(name = "shipping_date")
	@JsonView(JsonViews.Simple.class)
	private LocalDate date;
	@JsonView(JsonViews.Commande.class)
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
	@OneToMany(mappedBy = "id.commande")
	@JsonView(JsonViews.CommandeWithAchats.class)
	private Set<Achat> achats = new HashSet<>();

	public Set<Achat> getAchats() {
		return achats;
	}

	public void setAchats(Set<Achat> achats) {
		this.achats = achats;
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
