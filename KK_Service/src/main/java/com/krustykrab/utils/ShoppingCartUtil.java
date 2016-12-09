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
	
	public boolean createANewOrder(Long tableId, Long employeeId){
		if(ORDER_CACHE.containsKey(tableId)) return false;
		
		ShoppingCartResponse cart = new ShoppingCartResponse();
		cart.setTableId(tableId);
		cart.setEmployeeId(employeeId);

		ORDER_CACHE.put(tableId, cart);
				
		return true;
	}
	
	public ShoppingCartResponse addDishesToOrder(Long tableId, Dish dish, Integer amount){
		ShoppingCartResponse cart = ORDER_CACHE.get(tableId);

		if(amount>1){
			cart.addDishesToCart(dish, amount);
		}else if(amount==1){
			cart.addDishToCart(dish);
		}

		return cart;
	}
	
	@Transactional
	public void saveOrder(Long tableId){
		ShoppingCartResponse cart = ORDER_CACHE.remove(tableId);
		Order order = new Order();
		Employee employee = new Employee();
		employee.setId(cart.getEmployeeId());
		
		order.setTable(new Table(cart.getTableId()));
		order.setEmployee(employee);
		order.setDate(new Date());
		
		order = orderService.saveEntity(order);
		
		List<Dish_Order> detail = cart.getDishes();
				
		for(Dish_Order dishOrder : cart.getDishes()){
			dishOrder.setOrder(order);
		}
		
		dishOrderService.saveAll(detail);
	}
	
	public ShoppingCartResponse currentShoppingCart(Long tableId){
		return ORDER_CACHE.get(tableId);
	}
	
	public List<ShoppingCartResponse> deleteOrder(Long tableId){
		ORDER_CACHE.remove(tableId);
		return (List<ShoppingCartResponse>)ORDER_CACHE.values();
	}
	
	public void removeDishesFromOrder(Long tableId, Long dishId, Integer amount){
		ShoppingCartResponse shoppingCart = ORDER_CACHE.get(tableId);
		
		if(amount==null)return;
		
		if(amount>1){
			shoppingCart.removeDishesFromCart(dishId, amount);
		}else if (amount==1){
			shoppingCart.removeDishFromCart(dishId);
		}
	}
	
	
}
