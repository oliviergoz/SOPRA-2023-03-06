package ajc.formation.soprasteria.eshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.soprasteria.eshop.entities.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
	@Query("select f from Fournisseur f left join fetch f.produits where f.id=:id")
	Optional<Fournisseur> findByIdFetchProduits(@Param("id") Long id);
}
