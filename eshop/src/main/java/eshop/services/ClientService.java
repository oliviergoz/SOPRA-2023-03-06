package eshop.services;

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

import eshop.entities.Client;
import eshop.exceptions.ClientException;
import eshop.repositories.ClientRepository;
import eshop.repositories.CommandeRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CommandeRepository commandeRepository;

	public Client createOrUpdate(Client client) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		if (violations.isEmpty()) {
			return clientRepository.save(client);
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
