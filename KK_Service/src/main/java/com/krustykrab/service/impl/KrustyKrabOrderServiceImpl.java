package com.krustykrab.service.impl;

import java.util.Iterator;
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
		
		Iterable<Order> orders = dao.findAll();
		orders.forEach(order->order.setTotal(dao.getTotalForOrder(order.getId())));
		
		return (List<Order>) orders;
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
