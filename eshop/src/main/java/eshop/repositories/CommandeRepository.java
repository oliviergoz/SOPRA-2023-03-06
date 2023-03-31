package eshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
