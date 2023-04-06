package eshop.entities;

import java.io.Serializable;
import java.util.Objects;

import eshop.entities.Commande;
import eshop.entities.Produit;

public class AchatKey implements Serializable {

	private Long numero;
	private Long id;

	public AchatKey() {

	}

	public AchatKey(Long numero, Long id) {
		super();
		this.numero = numero;
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AchatKey other = (AchatKey) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero, other.numero);
	}

}
