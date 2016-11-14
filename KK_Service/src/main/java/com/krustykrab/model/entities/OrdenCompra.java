/**
 * 
 */
package com.krustykrab.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@AllArgsConstructor
@Entity
public class OrdenCompra
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Empleado empleado;
	
	@ManyToOne 
	private Proveedor proveedor;
	private String numero;
	private Date fecha;
	private char estado;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="ordenCompra")
	private List<OrdenCompra_Insumo> detalle;
}