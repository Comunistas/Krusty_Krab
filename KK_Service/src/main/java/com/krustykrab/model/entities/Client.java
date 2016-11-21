/**
 * 
 */
package com.krustykrab.model.entities;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client
{
	
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String lastName;
	private String idNumber;
	private String phoneNumber;
	private String email;
	
	
}

