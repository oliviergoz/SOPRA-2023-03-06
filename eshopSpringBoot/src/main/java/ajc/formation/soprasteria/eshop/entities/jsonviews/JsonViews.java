package ajc.formation.soprasteria.eshop.entities.jsonviews;

public class JsonViews {
	// vue pour les donnees simple (primitif,String,Date)
	public static class Simple {

	}

	// produit avec leur founisseur
	public static class ProduitWithFournisseur extends Simple {

	}

	public static class Fournisseur extends Simple {

	}

	// fournisseur avec sa liste de produits
	public static class FournisseurWithProduits extends Fournisseur {

	}

	public static class Client extends Simple {

	}

	public static class ClientWithCommandes extends Client {

	}

	public static class Commande extends Simple {

	}

	public static class CommandeWithAchats extends Commande {

	}
}
