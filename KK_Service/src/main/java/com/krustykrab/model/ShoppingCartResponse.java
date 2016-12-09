/**
 * 
 */
package com.krustykrab.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.krustykrab.model.entities.Dish;
import com.krustykrab.model.entities.Dish_Order;
import com.krustykrab.model.entities.Employee;
import com.krustykrab.model.entities.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@NoArgsConstructor
public class ShoppingCartResponse implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4908305060643088971L;
	private long tableId;
	private long employeeId;
	private Employee employee;
	private Table table;
	private List<Dish_Order> dishes;
	private double subtotal;
	
	{
		dishes = new ArrayList<Dish_Order>();
	}
	
	public ShoppingCartResponse(long tableId){
		this.tableId = tableId;
	}
	
	public void addDishToCart(Dish dish){
		addDishesWithAmount(dish, 1);
	}
	
	public void addDishesToCart(Dish dish, int amount){
		addDishesWithAmount(dish, amount);
	}
	
	private void addDishesWithAmount(Dish dish, int amount){
		Dish_Order dishOrder;
		if(hasDish(dish.getId())){
			dishOrder = getDishById(dish.getId());
			dishOrder.setAmount(dishOrder.getAmount()+amount);
		}else{
			dishOrder = new Dish_Order();
			dishOrder.setDish(dish);
			dishOrder.setAmount(amount);
			dishes.add(dishOrder);
		}
		calcSubtotal();
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
		calcSubtotal();	
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
	
	private void calcSubtotal(){
		subtotal = 0;
		dishes.forEach(dishOrder -> subtotal+=(dishOrder.getDish().getPrice()*dishOrder.getAmount()));
	}
	
}
