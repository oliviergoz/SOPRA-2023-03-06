package ajc.formation.soprasteria.eshop.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ajc.formation.soprasteria.eshop.entities.Achat;
import ajc.formation.soprasteria.eshop.entities.AchatId;
import ajc.formation.soprasteria.eshop.entities.Client;
import ajc.formation.soprasteria.eshop.entities.Commande;
import ajc.formation.soprasteria.eshop.entities.Compte;
import ajc.formation.soprasteria.eshop.entities.Produit;
import ajc.formation.soprasteria.eshop.services.ClientService;
import ajc.formation.soprasteria.eshop.services.CommandeService;
import ajc.formation.soprasteria.eshop.services.ProduitService;

@Controller
public class CommandeController {

	@Autowired
	private ProduitService produitSrv;
	@Autowired
	private ClientService clientSrv;
	@Autowired
	private CommandeService commandeSrv;

	@GetMapping("/achat/produit")
	public String listProduit(Model model, HttpSession session) {
		model.addAttribute("produits", produitSrv.getAll());
		if (session.getAttribute("panier") == null) {
			session.setAttribute("panier", new HashMap<Produit, Integer>());
		}
		return "achat/produits";
	}

	@GetMapping("/achat/addPanier")
	public String addPanier(@RequestParam Long id, Model model, HttpSession session) {
		Produit produit = produitSrv.getById(id);
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		if (panier.containsKey(produit)) {
			panier.put(produit, panier.get(produit) + 1);
		} else {
			panier.put(produit, 1);
		}
		return "redirect:/achat/produit";
	}

	@GetMapping("/achat/remove")
	public String remove(@RequestParam Long id, Model model, HttpSession session) {
		Produit produit = produitSrv.getById(id);
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		if (panier.get(produit) > 1) {
			panier.put(produit, panier.get(produit) - 1);
		} else {
			panier.remove(produit);
		}
		return "redirect:/achat/produit";
	}

//	@GetMapping("/achat/client")
//	public String login(Model model) {
//		model.addAttribute("clients", clientSrv.getAll());
//		return "achat/client";
//	}

	@GetMapping("/achat/save")
	public String saveCommande(@AuthenticationPrincipal UserDetails userDetails, HttpSession session) {
		Compte compte = (Compte) userDetails;
		Client client = compte.getClient();
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		Commande commande = new Commande(client);
		Set<Achat> achats = new HashSet<>();
		panier.forEach((k, v) -> {
			achats.add(new Achat(new AchatId(commande, k), v));
		});
		commande.setAchats(achats);
		commandeSrv.create(commande);
		session.invalidate();
		return "achat/ok";
	}
}
