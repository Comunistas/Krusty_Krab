/**
 * 
 */
package com.krustykrab.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.krustykrab.domain.pk.Plato_Pedido_PK;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
@Table
@IdClass(Plato_Pedido_PK.class)
public class Plato_Pedido implements DomainClass
{
	private static final long serialVersionUID = 6409370879860914090L;
	
	@Id @ManyToOne private Plato plato;
	@Id @ManyToOne private Pedido pedido;
	private int cantidad;
}
