/**
 * 
 */
package com.krustykrab.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Ingredient implements Serializable
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int currentStock;
	private String description;
	private char measureUnit;
	private String ingredientType;
}
