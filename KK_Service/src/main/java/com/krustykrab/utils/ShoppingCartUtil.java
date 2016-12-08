/**
 * 
 */
package com.krustykrab.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.ShoppingCartResponse;
import com.krustykrab.model.entities.Dish;
import com.krustykrab.model.entities.Dish_Order;
import com.krustykrab.model.entities.Employee;
import com.krustykrab.model.entities.Order;
import com.krustykrab.model.entities.Table;
import com.krustykrab.service.impl.KrustyKrabDish_OrderServiceImpl;
import com.krustykrab.service.impl.KrustyKrabOrderServiceImpl;

/**
 * @author Vladislav Zedano
 *
 */
@Component
public class ShoppingCartUtil
{

	@Autowired private KrustyKrabOrderServiceImpl orderService;
	@Autowired private KrustyKrabDish_OrderServiceImpl dishOrderService;
	
	/**
	 * This is the cache for the not concluded orders.
	 */
	private static Map<Long, ShoppingCartResponse> ORDER_CACHE = new HashMap<Long,ShoppingCartResponse>();
	
	public ShoppingCartResponse createANewOrder(long tableId, long employeeId){
		ShoppingCartResponse cart = new ShoppingCartResponse();
		cart.setTableId(tableId);
		cart.setEmployeeId(employeeId);
		
		return ORDER_CACHE.put(tableId, cart);
	}
	
	public ShoppingCartResponse addDishToOrder(long tableId, Dish dish){
		ShoppingCartResponse cart = ORDER_CACHE.get(tableId);
		cart.addDishToCart(dish);
		return cart;
	}
	
	@Transactional
	public void saveOrder(long tableId){
		ShoppingCartResponse cart = ORDER_CACHE.remove(tableId);
		Order order = new Order();
		Employee employee = new Employee();
		employee.setId(cart.getEmployeeId());
		
		order.setTable(new Table(cart.getTableId()));
		order.setEmployee(employee);
		order.setDate(new Date());
		
		order = orderService.saveEntity(order);
		
		List<Dish_Order> detail = new ArrayList<Dish_Order>();
		
		for(Dish dish : cart.getDishes()){
			Dish_Order dishOrder = new Dish_Order();
			dishOrder.setDish(dish);
			dishOrder.setOrder(order);
		}
		
		dishOrderService.saveAll(detail);
	}
	
	public ShoppingCartResponse currentShoppingCart(long tableId){
		return ORDER_CACHE.get(tableId);
	}
	
}
