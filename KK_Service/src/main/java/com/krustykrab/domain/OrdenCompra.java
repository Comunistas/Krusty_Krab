/**
 * 
 */
package com.krustykrab.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
@Table
public class OrdenCompra implements DomainClass
{
	private static final long serialVersionUID = -2081854833243400848L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
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
