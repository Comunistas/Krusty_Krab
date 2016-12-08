/**
 * 
 */
package com.krustykrab.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@AllArgsConstructor
@Entity
public class Supplier implements Serializable
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tin;
	private String companyName;
	private String phoneNumber;
	private String address;
	private String ingredientType;
}
