package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krustykrab.model.dao.SupplierDAO;
import com.krustykrab.model.entities.Supplier;
import com.krustykrab.service.KrustyKrabCrudService;

@Service
public class KrustyKrabSupplierServiceImpl implements KrustyKrabCrudService<Supplier> {
	@Autowired SupplierDAO SuppliereDAO;
	
	@Override
	public List<Supplier> getEntities() {
		return (List<Supplier>) SuppliereDAO.findAll();
	}
	
	@Override
	public Supplier saveEntity(Supplier entity) {
		return SuppliereDAO.save(entity);
	}

	@Override
	public Supplier getEntity(Long id) {
		return SuppliereDAO.findOne(id);
	}

	@Override
	public Supplier updateEntity(Supplier entity) {
		return SuppliereDAO.save(entity);
	}

	@Override
	public Supplier deleteEntity(Long id) {
		return null;
	}
}
