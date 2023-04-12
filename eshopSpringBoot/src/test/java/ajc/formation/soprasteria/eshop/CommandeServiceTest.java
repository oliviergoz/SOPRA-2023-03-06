package ajc.formation.soprasteria.eshop;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ajc.formation.soprasteria.eshop.entities.Achat;
import ajc.formation.soprasteria.eshop.entities.AchatId;
import ajc.formation.soprasteria.eshop.entities.Civilite;
import ajc.formation.soprasteria.eshop.entities.Client;
import ajc.formation.soprasteria.eshop.entities.Commande;
import ajc.formation.soprasteria.eshop.entities.Produit;
import ajc.formation.soprasteria.eshop.repositories.AchatRepository;
import ajc.formation.soprasteria.eshop.repositories.CommandeRepository;
import ajc.formation.soprasteria.eshop.repositories.ProduitRepository;
import ajc.formation.soprasteria.eshop.services.ClientService;

@SpringBootTest
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


	}

}
