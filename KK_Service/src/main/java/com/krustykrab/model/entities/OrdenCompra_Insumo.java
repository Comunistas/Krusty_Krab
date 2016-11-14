/**
 * 
 */
package com.krustykrab.model.entities;

import java.io.Serializable;

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
public class OrdenCompra_Insumo implements Serializable
{
	@Id @ManyToOne private Insumo insumo;
	@Id @ManyToOne private OrdenCompra ordenCompra;
	private int cantidad;
}
