package ajc.formation.soprasteria.eshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.soprasteria.eshop.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	Optional<Compte> findByLogin(String login);
}
