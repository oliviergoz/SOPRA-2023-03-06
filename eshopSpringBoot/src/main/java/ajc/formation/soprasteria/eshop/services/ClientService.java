
package ajc.formation.soprasteria.eshop.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.eshop.entities.Client;
import ajc.formation.soprasteria.eshop.exceptions.ClientException;
import ajc.formation.soprasteria.eshop.repositories.ClientRepository;
import ajc.formation.soprasteria.eshop.repositories.CommandeRepository;
import ajc.formation.soprasteria.eshop.repositories.CompteRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private CompteService compteSrv;

	public Client create(Client client) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		if (violations.isEmpty() && !compteSrv.loginExist(client.getCompte().getLogin())) {
			compteSrv.createUser(client.getCompte());
			return clientRepository.save(client);
		} else {
			throw new ClientException();
		}
	}

	public Client update(Client client) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		if (violations.isEmpty()) {
			Client clientEnBase = getById(client.getId());
			clientEnBase.setNom(client.getNom());
			clientEnBase.setPrenom(client.getPrenom());
			clientEnBase.setAdresse(client.getAdresse());
			clientEnBase.setCivilite(client.getCivilite());
			return clientRepository.save(clientEnBase);
		} else {
			throw new ClientException();
		}
	}

	public void delete(Client client) {
		Client clientEnBase = clientRepository.findById(client.getId()).orElseThrow(ClientException::new);
		commandeRepository.removeClientFromCommandeByClient(clientEnBase);
		clientRepository.delete(clientEnBase);
	}

	public void delete(Long id) {
		delete(clientRepository.findById(id).orElseThrow(ClientException::new));
	}

	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public Client getById(Long id) {
		return clientRepository.findById(id).orElseThrow(ClientException::new);
	}

	public Client getByIdFetchCommandes(Long id) {
		return clientRepository.findByIdFetchCommandes(id).orElseThrow(ClientException::new);
	}
}
