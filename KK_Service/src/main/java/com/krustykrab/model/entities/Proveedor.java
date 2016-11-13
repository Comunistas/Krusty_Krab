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

/**
 * @author Vladislav Zedano
 *
 */
@Data
@AllArgsConstructor
@Entity
public class Proveedor
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String ruc;
	private String razonSocial;
	private String telefono;
	private String direccion;
}
