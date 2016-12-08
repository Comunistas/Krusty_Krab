/**
 * 
 */
package com.krustykrab.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
@javax.persistence.Table(name="KrustyTable")
public class Table
{
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int number;
}
