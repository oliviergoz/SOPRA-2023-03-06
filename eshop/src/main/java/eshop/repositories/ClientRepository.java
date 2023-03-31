package eshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
