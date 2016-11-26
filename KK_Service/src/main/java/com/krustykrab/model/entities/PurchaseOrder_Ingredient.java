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

@Data
@AllArgsConstructor
@Entity
public class PurchaseOrder_Ingredient implements Serializable
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@ManyToOne private Ingredient ingredient;
	@ManyToOne private PurchaseOrder purchaseOrder;
	private int amount;
}
