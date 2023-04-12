package ajc.formation.soprasteria.eshop.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.soprasteria.eshop.entities.Client;
import ajc.formation.soprasteria.eshop.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

	@Transactional
	@Modifying
	@Query("update Commande c set c.client=null where c.client=:client")
	void removeClientFromCommandeByClient(@Param("client") Client client);

	List<Commande> findByClient(Client client);

	@Transactional
	@Query("select c from Commande c left join fetch c.achats where c.numero=:numero")
	Optional<Commande> findByNumeroFetchAchats(@Param("numero") Long numero);

}
