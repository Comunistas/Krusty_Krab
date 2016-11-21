package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.Receipt;

@Transactional
public interface ReceiptDAO extends CrudRepository<Receipt, Long> {

}
