package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krustykrab.model.dao.OrderDAO;
import com.krustykrab.model.entities.Order;
import com.krustykrab.service.KrustyKrabCrudService;

@Service
public class KrustyKrabOrderServiceImpl implements KrustyKrabCrudService<Order> {
	@Autowired OrderDAO dao;
	
	@Override
	public List<Order> getEntities() {
		return (List<Order>) dao.findAll();
	}
	
	@Override
	public Order saveEntity(Order entity) {
		return dao.save(entity);
	}

	@Override
	public Order getEntity(Long id) {
		return dao.findOne(id);
	}

	@Override
	public Order updateEntity(Order entity) {
		return dao.save(entity);
	}

	@Override
	public Order deleteEntity(Long id) {
		return null;
	}
}
