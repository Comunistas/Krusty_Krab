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

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
public class Pedido
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Empleado empleado;
	
	@ManyToOne
	private Mesa mesa;
	
	private String estado;
	private boolean delivery;
	private String direccion;
	private Date fecha;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="pedido")
	private List<Plato_Pedido> detalle;
}
