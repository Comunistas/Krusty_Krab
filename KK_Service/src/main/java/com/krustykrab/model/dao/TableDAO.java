package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.KTable;

@Transactional
public interface TableDAO extends CrudRepository<KTable, Long> {

}
