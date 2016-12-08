/**
 * 
 */
package com.krustykrab.model.entities;

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
public class Client implements Serializable
{
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String lastName;
	private String idNumber;
	private String phoneNumber;
	private String email;
}


