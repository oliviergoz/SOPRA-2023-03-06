package eshopWeb.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.entities.Achat;
import eshop.entities.AchatId;
import eshop.entities.Client;
import eshop.entities.Commande;
import eshop.entities.Produit;
import eshop.services.ClientService;
import eshop.services.CommandeService;
import eshop.services.ProduitService;

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

	@GetMapping("/achat/client")
	public String login(Model model) {
		model.addAttribute("clients", clientSrv.getAll());
		return "achat/client";
	}

	@PostMapping("/achat/save")
	public String saveCommande(@RequestParam Long id, HttpSession session) {
		Client client = clientSrv.getById(id);
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		Commande commande = new Commande(client);
		Set<Achat> achats = new HashSet<>();
		panier.forEach((k, v) -> {
			achats.add(new Achat(new AchatId(commande, k) , v));
		});
		commande.setAchats(achats);
		commandeSrv.create(commande);
		session.invalidate();
		return "achat/ok";
	}
}
