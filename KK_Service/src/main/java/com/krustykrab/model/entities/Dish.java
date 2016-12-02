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
import java.io.Serializable;

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
public class Dish implements Serializable
{
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private double price;
	private int dailyStock;
	private int currentStock;
	
	@OneToMany(mappedBy="dish")
	private List<Ingredient_Dish> ingredients;
}
