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
public class Cliente
{
	
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String dni;
	private String telefono;
	private String correo;
	
	
}


