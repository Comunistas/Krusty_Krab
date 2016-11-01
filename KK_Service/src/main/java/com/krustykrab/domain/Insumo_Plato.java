/**
 * 
 */
package com.krustykrab.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.krustykrab.domain.pk.Insumo_Plato_PK;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@Entity
@Table
@IdClass(Insumo_Plato_PK.class)
public class Insumo_Plato implements DomainClass
{	
	private static final long serialVersionUID = 7666323367903515842L;
	
	@Id @ManyToOne private Insumo insumo;
	@Id @ManyToOne private Plato plato;
	private int cantidad;
}
