package ajc.formation.soprasteria.eshop.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.eshop.entities.Client;
import ajc.formation.soprasteria.eshop.entities.jsonviews.JsonViews;
import ajc.formation.soprasteria.eshop.services.ClientService;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*")
public class ClientRestController {
	@Autowired
	private ClientService clientSrv;

	@GetMapping("")
	@JsonView(JsonViews.ClientWithCompte.class)
	public List<Client> getAll() {
		return clientSrv.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.ClientWithCompte.class)
	public Client getById(@PathVariable Long id) {
		Client client = null;
		client = clientSrv.getById(id);
		return client;
	}

	@GetMapping("/{id}/commandes")
	@JsonView(JsonViews.ClientWithCompte.class)
	public Client getByIdWithCommandes(@PathVariable Long id) {
		Client client = null;
		client = clientSrv.getByIdFetchCommandes(id);
		return client;
	}

	@PostMapping({ "", "/inscription" })
	@JsonView(JsonViews.ClientWithCompte.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		clientSrv.create(client);
		return client;
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.ClientWithCompte.class)
	public Client update(@RequestBody Client client, @PathVariable Long id) {
		Client clientEnBase = clientSrv.getById(id);
		if (client.getNom() != null) {
			clientEnBase.setNom(client.getNom());
		}
		if (client.getPrenom() != null) {
			clientEnBase.setPrenom(client.getPrenom());
		}
		if (client.getAdresse() != null) {
			clientEnBase.setAdresse(client.getAdresse());
		}
		if (client.getCivilite() != null) {
			clientEnBase.setCivilite(client.getCivilite());
		}
		clientSrv.update(clientEnBase);
		return clientEnBase;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clientSrv.delete(id);
	}
}
