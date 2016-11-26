package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.krustykrab.model.dao.OrderDAO;
import com.krustykrab.model.entities.Order;
import com.krustykrab.service.KrustyKrabCrudService;

public class KrustyKrabOrderServiceImpl implements KrustyKrabCrudService<Order> {
	@Autowired OrderDAO OrdereDAO;
	
	@Override
	public List<Order> getEntities() {
		return (List<Order>) OrdereDAO.findAll();
	}
	
	@Override
	public Order saveEntity(Order entity) {
		return OrdereDAO.save(entity);
	}

	@Override
	public Order getEntity(Long id) {
		return OrdereDAO.findOne(id);
	}

	@Override
	public Order updateEntity(Order entity) {
		return OrdereDAO.save(entity);
	}

	@Override
	public Order deleteEntity(Long id) {
		return null;
	}
}
