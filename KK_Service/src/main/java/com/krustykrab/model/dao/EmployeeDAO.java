package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.Employee;

@Transactional
public interface EmployeeDAO extends CrudRepository<Employee, Long> {

}
