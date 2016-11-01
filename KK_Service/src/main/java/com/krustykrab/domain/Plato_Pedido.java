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
public class Plato_Pedido implements DomainClass
{
	private static final long serialVersionUID = 6409370879860914090L;
	
	@Id private int id;
	@ManyToOne private Plato plato;
	@ManyToOne private Pedido pedido;
	private int cantidad;
}
