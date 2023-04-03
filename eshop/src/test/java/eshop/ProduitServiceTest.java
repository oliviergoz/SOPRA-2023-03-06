package eshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.config.JpaConfig;
import eshop.entities.Produit;
import eshop.services.ProduitService;

class ProduitServiceTest {

	static AnnotationConfigApplicationContext ctx = null;

	ProduitService produitService;

	@BeforeAll
	static void initSpring() {
		ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
	}

	@AfterAll
	static void closeSring() {
		ctx.close();
	}

	@BeforeEach
	void getProduitService() {
		produitService = ctx.getBean(ProduitService.class);
	}

	@Test
	void produitServiceExisttest() {
		assertNotNull(produitService);
	}

	@Test
	void insertTest() {
		Produit produit = new Produit("test1", 1000);
		produitService.createOrUpdate(produit);
		assertNotNull(produit.getId());
	}
}