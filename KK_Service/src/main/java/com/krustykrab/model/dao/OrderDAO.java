package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.Order;

@Transactional
public interface OrderDAO extends CrudRepository<Order, Long> {

}
