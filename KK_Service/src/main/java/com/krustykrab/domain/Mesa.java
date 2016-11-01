/**
 * 
 */
package com.krustykrab.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
@Table
public class Mesa implements DomainClass
{
	private static final long serialVersionUID = -513145707852915569L;
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int numero;
}
