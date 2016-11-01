/**
 * 
 */
package com.krustykrab.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class ComprobantePago implements DomainClass
{
	private static final long serialVersionUID = -2425163719227038840L;
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
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
