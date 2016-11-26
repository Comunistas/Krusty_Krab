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

import lombok.Data;

@Data
@Entity
public class Dish_Order implements Serializable
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@ManyToOne private Dish dish;
	@ManyToOne private Order order;
	private int amount;
}
