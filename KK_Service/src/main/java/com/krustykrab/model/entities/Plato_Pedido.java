/**
 * 
 */
package com.krustykrab.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
public class Plato_Pedido implements Serializable
{
	@Id @ManyToOne private Plato plato;
	@Id @ManyToOne private Pedido pedido;
	private int cantidad;
}
