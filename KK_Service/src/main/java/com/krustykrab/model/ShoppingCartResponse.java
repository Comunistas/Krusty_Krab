/**
 * 
 */
package com.krustykrab.model;

import java.util.ArrayList;
import java.util.List;

import com.krustykrab.model.entities.Dish;

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
	private List<Dish> dishes;
	private double subtotal;
	
	public ShoppingCartResponse(long tableId){
		this.tableId = tableId;
		dishes = new ArrayList<Dish>();
	}
	
	public void addDishToCart(Dish dish){
		dishes.add(dish);
	}
}
