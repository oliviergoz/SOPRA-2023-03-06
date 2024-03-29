package eshop.restcontroller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.entities.Achat;
import eshop.entities.AchatId;
import eshop.entities.Commande;
import eshop.entities.jsonviews.JsonViews;
import eshop.model.ElementPanier;
import eshop.services.ClientService;
import eshop.services.CommandeService;
import eshop.services.ProduitService;

@RestController
@RequestMapping("/api/commande")
public class CommandeRestController {

	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ClientService clientSrv;
	@Autowired
	private ProduitService produitSrv;

	@GetMapping("")
	@JsonView(JsonViews.Commande.class)
	public List<Commande> getAll() {
		return commandeService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Commande.class)
	public Commande getById(@PathVariable("id") Long numero) {
		return commandeService.getByNumero(numero);
	}

	@GetMapping("/{id}/detail")
	@JsonView(JsonViews.CommandeWithAchats.class)
	public Commande getByIdWithAchats(@PathVariable("id") Long numero) {
		return commandeService.detail(numero);
	}

	@PostMapping("/{id}")
	@JsonView(JsonViews.Commande.class)
	public Commande create(@RequestBody List<ElementPanier> panier, @PathVariable("id") Long idClient) {
		Commande commande = new Commande(clientSrv.getById(idClient));
		Set<Achat> achats = new HashSet<>();
		panier.forEach(e -> {
			achats.add(new Achat(new AchatId(commande, produitSrv.getById(e.getIdProduit())), e.getQuantite()));
		});
		commande.setAchats(achats);
		commandeService.create(commande);
		return commande;
	}
}
