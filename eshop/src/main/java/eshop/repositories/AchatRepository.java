package eshop.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.entities.Achat;
import eshop.entities.AchatId;
import eshop.entities.AchatKey;
import eshop.entities.Commande;

public interface AchatRepository extends JpaRepository<Achat, AchatId> {
	@Modifying
	@Transactional
	@Query("delete from Achat a where a.id.commande=:commande")
	void deleteByCommande(@Param("commande") Commande commande);
}
