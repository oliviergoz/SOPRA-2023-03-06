package eshop;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import eshop.config.JpaConfig;
import eshop.entities.Produit;
import eshop.exceptions.ProduitException;
import eshop.services.ProduitService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class ProduitServiceSpringTest {

	@Autowired
	ProduitService produitService;

	@Disabled
	@Test
	@Commit
	void initProduit() {
		produitService.createOrUpdate(new Produit("produit1", 10));
		produitService.createOrUpdate(new Produit("produit2", 100));
		produitService.createOrUpdate(new Produit("produit3", 1000));
	}

	@Test
	void injectionProduitServiceTest() {
		assertNotNull(produitService);
	}

	@Test
	void insertProduitTest() {
		Produit p = new Produit("toto", 1000);
		produitService.createOrUpdate(p);
		assertNotNull(produitService.getById(p.getId()));
	}

	@Test
	void getByIdWithProduitException() {
		assertThrows(ProduitException.class, () -> produitService.getById(9999L));
	}

}
