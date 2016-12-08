/**
 * 
 */
package com.krustykrab.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import java.io.Serializable;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
public class Employee implements Serializable
{
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastName;
	private String idNumber;
	private Date birthDate;
}