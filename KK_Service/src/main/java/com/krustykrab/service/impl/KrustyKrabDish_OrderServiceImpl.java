package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.krustykrab.model.dao.Dish_OrderDAO;
import com.krustykrab.model.entities.Dish_Order;
import com.krustykrab.service.KrustyKrabCrudService;

public class KrustyKrabDish_OrderServiceImpl implements KrustyKrabCrudService<Dish_Order> {
	@Autowired Dish_OrderDAO Dish_OrdereDAO;
	
	@Override
	public List<Dish_Order> getEntities() {
		return (List<Dish_Order>) Dish_OrdereDAO.findAll();
	}
	
	@Override
	public Dish_Order saveEntity(Dish_Order entity) {
		return Dish_OrdereDAO.save(entity);
	}

	@Override
	public Dish_Order getEntity(Long id) {
		return Dish_OrdereDAO.findOne(id);
	}

	@Override
	public Dish_Order updateEntity(Dish_Order entity) {
		return Dish_OrdereDAO.save(entity);
	}

	@Override
	public Dish_Order deleteEntity(Long id) {
		return null;
	}
}
