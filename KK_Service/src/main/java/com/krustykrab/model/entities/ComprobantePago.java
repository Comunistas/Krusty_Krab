/**
 * 
 */
package com.krustykrab.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class ComprobantePago
{
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Pedido pedido;
	
	private Date fecha;
	private String ruc;
	private boolean factura;
	private String razonSocial;
	private char medioPago;
	private String numeroTarjeta;
	private double subtotal;
	private double igv;
	private double totalAPagar;
}
