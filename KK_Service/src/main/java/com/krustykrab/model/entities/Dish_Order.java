/**
 * 
 */
package com.krustykrab.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
public class Dish_Order implements Serializable
{
	@Id @ManyToOne private Dish dish;
	@Id @ManyToOne private Order order;
	private int amount;
}
