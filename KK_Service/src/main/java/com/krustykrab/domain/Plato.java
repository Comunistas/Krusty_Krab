/**
 * 
 */
package com.krustykrab.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Plato implements DomainClass
{
	private static final long serialVersionUID = 2373341920455020952L;
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;
	private double precio;
	private int cantidadStockDiario;
	private int stockActual;
	
	@OneToMany
	private List<Insumo_Plato> insumos;
}
