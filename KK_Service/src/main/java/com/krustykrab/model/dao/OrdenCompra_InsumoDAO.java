package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.Cliente;

@Transactional
public interface OrdenCompra_InsumoDAO extends CrudRepository<Cliente, Long> {

}