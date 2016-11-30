/**
 * 
 */
package com.krustykrab.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dish
{
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private double price;
	private int dailyStock;
	
	@OneToMany(mappedBy="dish")
	private List<Ingredient_Dish> ingredients;
}
