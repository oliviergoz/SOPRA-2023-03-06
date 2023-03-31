package eshop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.config.JpaConfig;
import eshop.dao.DaoProduit;
import eshop.entities.Produit;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		DaoProduit daoProduit = ctx.getBean(DaoProduit.class);
		daoProduit.save(new Produit("llll", 10));
		ctx.close();
	}
}
