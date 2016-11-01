/**
 * 
 */
package com.krustykrab.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.krustykrab.domain.pk.OrdenCompra_Insumo_PK;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
@Table
@IdClass(OrdenCompra_Insumo_PK.class)
public class OrdenCompra_Insumo implements DomainClass
{
	private static final long serialVersionUID = -3144161230332274939L;
	
	@Id	@ManyToOne private Insumo insumo;
	@Id	@ManyToOne private OrdenCompra ordenCompra;
	private int cantidad;
}
