/**
 * 
 */
package com.krustykrab.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
@javax.persistence.Table(name="KrustyOrder")
public class Order implements Serializable
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Employee employee;
	
	@ManyToOne(targetEntity=Table.class)
	private Table table;

	private Date date;
}
