/**
 * 
 */
package com.krustykrab.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@AllArgsConstructor
@Entity
public class Ingredient_Dish implements Serializable
{	
	@Id @ManyToOne private Ingredient ingredient;
	@Id @ManyToOne private Dish dish;
	private int amount;
}
