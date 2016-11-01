/**
 * 
 */
package com.krustykrab.domain.pk;

import com.krustykrab.domain.DomainClass;
import com.krustykrab.domain.Pedido;
import com.krustykrab.domain.Plato;

import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
public class Plato_Pedido_PK implements DomainClass
{
	private static final long serialVersionUID = 7944466785262244174L;
	private Plato plato;
	private Pedido pedido;
}
