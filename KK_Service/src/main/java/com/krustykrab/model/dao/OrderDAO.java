package com.krustykrab.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.Order;

@Transactional
public interface OrderDAO extends CrudRepository<Order, Long> {
	
	@Query("select sum(d.price*do.amount) total from Dish d join DishOrder do join Order o where o.id = ?1")
	public double getTotalForOrder(Long id);
}
