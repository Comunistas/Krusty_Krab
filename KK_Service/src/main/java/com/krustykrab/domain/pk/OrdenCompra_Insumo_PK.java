/**
 * 
 */
package com.krustykrab.domain.pk;

import com.krustykrab.domain.DomainClass;
import com.krustykrab.domain.Insumo;
import com.krustykrab.domain.OrdenCompra;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
public class OrdenCompra_Insumo_PK implements DomainClass
{
	private static final long serialVersionUID = 6884303338933652028L;
	private OrdenCompra ordenCompra;
	private Insumo insumo;
}
