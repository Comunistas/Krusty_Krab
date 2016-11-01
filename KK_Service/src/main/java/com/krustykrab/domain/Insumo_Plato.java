/**
 * 
 */
package com.krustykrab.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
@Table
public class Insumo_Plato implements DomainClass
{	
	private static final long serialVersionUID = 7666323367903515842L;
	
	@Id private int id;
	@ManyToOne private Insumo insumo;
	@ManyToOne private Plato plato;
	private int cantidad;
}
