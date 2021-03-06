package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.PurchaseOrder;

@Transactional
public interface PurchaseOrderDAO extends CrudRepository<PurchaseOrder, Long> {

}
