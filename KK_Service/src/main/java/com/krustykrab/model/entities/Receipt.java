/**
 * 
 */
package com.krustykrab.model.entities;

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
public class Receipt
{
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Order order;
	
	private Date date;
	private String tin;
	private boolean invoice;
	private String companyName;
	private char paymentMethod;
	private String cardNumber;
	private double subtotal;
	private double vat;
	private double totalCost;
}
