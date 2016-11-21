/**
 * 
 */
package com.krustykrab.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
@Table(name="KrustyOrder")
public class Order
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	private Table table;
	
	private String state;
	private boolean delivery;
	private String address;
	private Date date;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="order")
	private List<Dish_Order> detail;
}
