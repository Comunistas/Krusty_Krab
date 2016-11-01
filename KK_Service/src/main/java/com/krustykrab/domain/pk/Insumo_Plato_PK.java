package com.krustykrab.domain.pk;

import javax.persistence.Embeddable;

import com.krustykrab.domain.DomainClass;
import com.krustykrab.domain.Insumo;
import com.krustykrab.domain.Plato;

import lombok.Data;

@Data
@Embeddable
public class Insumo_Plato_PK implements DomainClass{
	private static final long serialVersionUID = 1864763318382317168L;
	private Plato plato;
	private Insumo insumo;
}