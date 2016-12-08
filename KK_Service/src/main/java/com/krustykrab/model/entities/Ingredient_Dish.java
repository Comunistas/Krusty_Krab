/**
 * 
 */
package com.krustykrab.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient_Dish implements Serializable
{	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@ManyToOne private Ingredient ingredient;
	@ManyToOne private Dish dish;
	private int amount;
}
