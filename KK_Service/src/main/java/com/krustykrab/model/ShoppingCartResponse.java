/**
 * 
 */
package com.krustykrab.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.krustykrab.model.entities.Dish;
import com.krustykrab.model.entities.Dish_Order;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@NoArgsConstructor
public class ShoppingCartResponse
{
	private long tableId;
	private long employeeId;
	private List<Dish_Order> dishes;
	private double subtotal;
	
	public ShoppingCartResponse(long tableId){
		this.tableId = tableId;
		dishes = new ArrayList<Dish_Order>();
	}
	
	public void addDishToCart(Dish dish){
		addDishesWithAmount(dish, 1);
	}
	
	public void addDishesToCart(Dish dish, int amount){
		addDishesWithAmount(dish, amount);
	}
	
	private void addDishesWithAmount(Dish dish, int amount){
		
		if(hasDish(dish.getId())){
			Dish_Order dishOrder = getDishById(dish.getId());
			dishOrder.setAmount(dishOrder.getAmount()+amount);
		}
		
	}
	
	private void removeDishesWithAmount(long dishId, int amount){
		if(hasDish(dishId)){
			Dish_Order dishOrder = getDishById(dishId);
			
			int allAmount = dishOrder.getAmount();
			
			if(allAmount>amount){
				dishOrder.setAmount(allAmount-amount);
			}else{
				dishes.removeIf(item -> item.getDish().getId().equals(dishId));
			}
		}
		
	}
	
	private boolean hasDish(long dishId){
		return getDishById(dishId) != null;
	}
	
	private Dish_Order getDishById(long dishId){
		Dish_Order dishOrder = null;
		
		Predicate<Dish_Order> pred = (item) -> item.getDish().getId().equals(dishId);
		if(dishes.stream().anyMatch(pred)){
			dishOrder = dishes.stream().filter(pred).findFirst().get();
		}

		return dishOrder;
	}
	
	public void removeDishFromCart(long dishId){
		removeDishesWithAmount(dishId, 1);
	}
	
	public void removeDishesFromCart(long dishId, int amount){
		removeDishesWithAmount(dishId, amount);
	}
	
}
