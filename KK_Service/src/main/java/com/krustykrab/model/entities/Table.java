/**
 * 
 */
package com.krustykrab.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
@NoArgsConstructor
@javax.persistence.Table(name="KrustyTable")
public class Table implements Serializable
{
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int number;
	
	public Table(long id){
		this.id = id;
	}
}
