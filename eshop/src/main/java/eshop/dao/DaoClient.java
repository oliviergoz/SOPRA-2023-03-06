package eshop.dao;

import eshop.entities.Client;

public interface DaoClient extends DaoGeneric<Client, Long> {
	public Client findByIdfetchCommandefetchAchats(Long id);
}
