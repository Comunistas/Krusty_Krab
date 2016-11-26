package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krustykrab.model.dao.ClientDAO;
import com.krustykrab.model.entities.Client;
import com.krustykrab.service.KrustyKrabCrudService;

@Service
public class KrustyKrabClientServiceImpl implements KrustyKrabCrudService<Client>{

	@Autowired ClientDAO clienteDAO;
	
	@Override
	public List<Client> getEntities() {
		return (List<Client>) clienteDAO.findAll();
	}
	
	@Override
	public Client saveEntity(Client entity) {
		return clienteDAO.save(entity);
	}

	@Override
	public Client getEntity(Long id) {
		return clienteDAO.findOne(id);
	}

	@Override
	public Client updateEntity(Client entity) {
		return clienteDAO.save(entity);
	}

	@Override
	public Client deleteEntity(Long id) {
		return null;
	}

	
}
