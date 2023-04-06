package eshop;

import static org.junit.jupiter.api.Assertions.assertFalse;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import eshop.config.JpaConfig;
import eshop.entities.Achat;
import eshop.entities.AchatId;
import eshop.entities.Civilite;
import eshop.entities.Client;
import eshop.entities.Commande;
import eshop.entities.Produit;
import eshop.repositories.AchatRepository;
import eshop.repositories.CommandeRepository;
import eshop.repositories.ProduitRepository;
import eshop.services.ClientService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class CommandeServiceTest {

	@Autowired
	CommandeRepository commandeRepo;

	@Autowired
	AchatRepository achatRepo;

	@Autowired
	ProduitRepository produitRepo;

	@Autowired
	ClientService clientSrv;

	@Test
	void insertCommandeAvecRepoTest() {
		Client client = new Client("lll", null, "lllll", Civilite.M);
		clientSrv.createOrUpdate(client);
		Commande commande = new Commande(client);

		commandeRepo.save(commande);

		Produit produit = new Produit("aaa", 1000);
		produitRepo.save(produit);

		Achat achat = new Achat(new AchatId(commande, produit) , 1);
//
		achatRepo.save(achat);
//		
		commande = commandeRepo.findByNumeroFetchAchats(commande.getNumero()).get();
		System.out.println(commande.getAchats());

	}

}
