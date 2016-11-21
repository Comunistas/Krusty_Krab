package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.Dish_Order;

@Transactional
public interface Dish_OrderDAO extends CrudRepository<Dish_Order, Long> {

}
