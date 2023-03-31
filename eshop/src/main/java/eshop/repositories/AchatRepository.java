package eshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.entities.Achat;
import eshop.entities.AchatKey;

public interface AchatRepository extends JpaRepository<Achat, AchatKey> {

}
