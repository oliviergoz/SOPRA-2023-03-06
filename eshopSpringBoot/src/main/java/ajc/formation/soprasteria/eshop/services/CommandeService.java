package ajc.formation.soprasteria.eshop.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.eshop.entities.Client;
import ajc.formation.soprasteria.eshop.entities.Commande;
import ajc.formation.soprasteria.eshop.exceptions.CommandeException;
import ajc.formation.soprasteria.eshop.repositories.AchatRepository;
import ajc.formation.soprasteria.eshop.repositories.CommandeRepository;

@Service
public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private AchatRepository achatRepository;
	@Autowired
	private Validator validator;

	public Commande create(Commande commande) {
		Set<ConstraintViolation<Commande>> violations = validator.validate(commande);
		if (violations.isEmpty()) {
			commandeRepository.save(commande);

			achatRepository.saveAll(commande.getAchats());
			return commande;
		} else {
			throw new CommandeException();
		}
	}

	public List<Commande> getAll() {
		return commandeRepository.findAll();
	}

	public Commande getByNumero(Long numero) {
		return commandeRepository.findById(numero).orElseThrow(CommandeException::new);
	}

	public List<Commande> getByClient(Client client) {
		return commandeRepository.findByClient(client);
	}

	public void delete(Commande commande) {
		achatRepository.deleteByCommande(commande);
		commandeRepository.delete(commande);
	}

	public Commande detail(Commande commande) {
		return detail(commande.getNumero());
	}

	public Commande detail(Long numero) {
		return commandeRepository.findByNumeroFetchAchats(numero).orElseThrow(CommandeException::new);
	}

}
