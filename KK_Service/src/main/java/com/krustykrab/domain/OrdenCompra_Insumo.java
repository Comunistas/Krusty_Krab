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
public class OrdenCompra_Insumo implements DomainClass
{
	private static final long serialVersionUID = -3144161230332274939L;
	
	@Id private int id;
	@ManyToOne private Insumo insumo;
	@ManyToOne private OrdenCompra ordenCompra;
	private int cantidad;
}
