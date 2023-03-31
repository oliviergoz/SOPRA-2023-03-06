package eshop;

import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.config.JpaConfig;
import eshop.entities.Fournisseur;
import eshop.entities.Produit;
import eshop.repositories.FournisseurRepository;
import eshop.repositories.ProduitRepository;
import eshop.services.FournisseurService;
import eshop.services.ProduitService;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		FournisseurService frsSrv = ctx.getBean(FournisseurService.class);
		ProduitService prodSrv = ctx.getBean(ProduitService.class);
		Fournisseur f = new Fournisseur("aa", null, "mmmm");

		frsSrv.createOrUpdate(f);

		// frsSrv.createOrUpdate(new Fournisseur(null, null, null));
		Produit p = new Produit("aaa", 100, "lkjkljkljlk", f);
		prodSrv.createOrUpdate(p);

		frsSrv.delete(f);
		ctx.close();
	}
}
