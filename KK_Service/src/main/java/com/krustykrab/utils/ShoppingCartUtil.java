/**
 * 
 */
package com.krustykrab.utils;

import java.util.Collection;
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
import com.krustykrab.service.impl.KrustyKrabEmployeeServiceImpl;
import com.krustykrab.service.impl.KrustyKrabOrderServiceImpl;
import com.krustykrab.service.impl.KrustyKrabTableServiceImpl;

/**
 * @author Vladislav Zedano
 *
 */
@Component
public class ShoppingCartUtil
{

	@Autowired private KrustyKrabOrderServiceImpl orderService;
	@Autowired private KrustyKrabDish_OrderServiceImpl dishOrderService;
	@Autowired private KrustyKrabEmployeeServiceImpl employeeService;
	@Autowired private KrustyKrabTableServiceImpl tableService;
	
	/**
	 * This is the cache for the not concluded orders.
	 */
	private static Map<Long, ShoppingCartResponse> ORDER_CACHE = new HashMap<Long,ShoppingCartResponse>();
	
	public boolean createANewOrder(Long tableId, Long employeeId){
		if(ORDER_CACHE.containsKey(tableId)) return false;
		
		ShoppingCartResponse cart = new ShoppingCartResponse();
		cart.setTableId(tableId);
		cart.setEmployeeId(employeeId);
		cart.setEmployee(employeeService.getEntity(employeeId));
		cart.setTable(tableService.getEntity(tableId));

		if(cart.getEmployee()==null || cart.getTable()==null) return false;
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
	
	public ShoppingCartResponse removeDishesFromOrder(Long tableId, Long dishId, Integer amount){
		ShoppingCartResponse cart = ORDER_CACHE.get(tableId);
		
		if(amount==null)return null;
		
		if(amount>1){
			cart.removeDishesFromCart(dishId, amount);
		}else if (amount==1){
			cart.removeDishFromCart(dishId);
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
	
	public ShoppingCartResponse getShoppingCartForTable(Long tableId){
		return ORDER_CACHE.get(tableId);
	}
	
	public Collection<ShoppingCartResponse> deleteOrder(Long tableId){
		ORDER_CACHE.remove(tableId);
		return ORDER_CACHE.values();
	}
	
	public Collection<ShoppingCartResponse> getAllCarts(){
		return ORDER_CACHE.values();
	}
	

	
	
}
