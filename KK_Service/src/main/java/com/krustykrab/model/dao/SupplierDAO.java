package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.Supplier;

@Transactional
public interface SupplierDAO extends CrudRepository<Supplier, Long>{

}
