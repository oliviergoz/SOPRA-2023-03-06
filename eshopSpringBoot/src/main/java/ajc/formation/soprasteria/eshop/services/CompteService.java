package ajc.formation.soprasteria.eshop.services;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.eshop.entities.Compte;
import ajc.formation.soprasteria.eshop.entities.Role;
import ajc.formation.soprasteria.eshop.exceptions.CompteException;
import ajc.formation.soprasteria.eshop.repositories.CompteRepository;

@Service
public class CompteService {

	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private Validator validator;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Compte createUser(Compte compte) {
		compte.setRole(Role.ROLE_USER);
		return create(compte);
	}

	public Compte createAdmin(Compte compte) {
		compte.setRole(Role.ROLE_ADMIN);
		return create(compte);
	}

	private Compte create(Compte compte) {
		if (!validator.validate(compte).isEmpty()) {
			throw new CompteException();
		}
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		return compteRepo.save(compte);
	}

	public Compte findByLogin(String login) {
		return compteRepo.findByLogin(login).orElseThrow(() -> {
			throw new CompteException();
		});
	}
	
	public boolean loginExist(String login) {
		return compteRepo.findByLogin(login).isPresent();
	}
}
