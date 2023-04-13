package ajc.formation.soprasteria.eshop.controllers;

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

import ajc.formation.soprasteria.eshop.entities.Civilite;
import ajc.formation.soprasteria.eshop.entities.Client;
import ajc.formation.soprasteria.eshop.services.ClientService;

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
		model.addAttribute("create", false);
		return form(model, clientSrv.getById(id));
	}

	@GetMapping({"/add","/inscription"})
	public String create(Model model) {
		model.addAttribute("create", true);
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
	public String save(@Valid @ModelAttribute Client client, BindingResult br, Model model,
			@RequestParam boolean create) {
		if (br.hasErrors()) {
			return form(model, client);
		}
		if (create) {
			clientSrv.create(client);
		} else {
			clientSrv.update(client);
		}
		return "redirect:/client";
	}

}
