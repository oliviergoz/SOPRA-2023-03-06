package eshop.entities;

public enum Civilite {
	M("monsieur"), MME("madame");

	private String texte;

	private Civilite(String texte) {
		this.texte = texte;
	}

	public String getTexte() {
		return texte;
	}
}
