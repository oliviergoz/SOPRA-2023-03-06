package eshopWeb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.entities.Civilite;
import eshop.entities.Client;
import eshop.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientSrv;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("clients", clientSrv.getAll());
		return "client/client";
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam Long id) {
		return form(model, clientSrv.getById(id));
	}

	@GetMapping("/add")
	public String create(Model model) {
		return form(model, new Client());
	}

	private String form(Model model, Client client) {
		model.addAttribute("client", client);
		model.addAttribute("civilites", Civilite.values());
		return "client/edit";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		clientSrv.delete(id);
		return "redirect:/client";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Client client, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return form(model, client);
		}
		clientSrv.createOrUpdate(client);
		return "redirect:/client";
	}

}
