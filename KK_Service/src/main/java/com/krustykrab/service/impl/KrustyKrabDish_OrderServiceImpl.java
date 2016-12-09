package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krustykrab.model.dao.Dish_OrderDAO;
import com.krustykrab.model.entities.Dish_Order;
import com.krustykrab.model.entities.Order;
import com.krustykrab.service.KrustyKrabCrudService;

@Service
public class KrustyKrabDish_OrderServiceImpl implements KrustyKrabCrudService<Dish_Order> {
	@Autowired Dish_OrderDAO dao;
	
	@Override
	public List<Dish_Order> getEntities() {
		return (List<Dish_Order>) dao.findAll();
	}
	
	public List<Dish_Order> getAllByOrder(Order order){
		return (List<Dish_Order>)dao.findByOrder(order);
	}
	
	public List<Dish_Order> saveAll(List<Dish_Order> dishesPerOrder){
		return (List<Dish_Order>) dao.save(dishesPerOrder);
	}
	
	@Override
	public Dish_Order saveEntity(Dish_Order entity) {
		return dao.save(entity);
	}

	@Override
	public Dish_Order getEntity(Long id) {
		return dao.findOne(id);
	}

	@Override
	public Dish_Order updateEntity(Dish_Order entity) {
		return dao.save(entity);
	}

	@Override
	public Dish_Order deleteEntity(Long id) {
		return null;
	}
}
