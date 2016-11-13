/**
 * 
 */
package com.krustykrab.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@AllArgsConstructor
@Entity
public class Insumo_Plato
{	
	
	@Id private Long id;
	@ManyToOne private Insumo insumo;
	@ManyToOne private Plato plato;
	private int cantidad;
}
