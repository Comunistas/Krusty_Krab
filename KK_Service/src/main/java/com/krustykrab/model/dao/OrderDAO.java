package com.krustykrab.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.Order;

@Transactional
public interface OrderDAO extends CrudRepository<Order, Long> {
	
	@Query(value="select sum(d.price*dor.amount) from Dish as d inner join Dish_Order as dor inner join Krusty_Order as o on dor.order_id=o.id where o.id = ?1", nativeQuery=true)
	public double getTotalForOrder(Long id);
}
