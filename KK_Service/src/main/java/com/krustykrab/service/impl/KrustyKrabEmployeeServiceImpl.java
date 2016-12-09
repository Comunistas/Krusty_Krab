package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krustykrab.model.dao.EmployeeDAO;
import com.krustykrab.model.entities.Employee;
import com.krustykrab.service.KrustyKrabCrudService;

@Service
public class KrustyKrabEmployeeServiceImpl implements KrustyKrabCrudService<Employee>{
	@Autowired EmployeeDAO EmployeeeDAO;
	
	@Override
	public List<Employee> getEntities() {
		return (List<Employee>) EmployeeeDAO.findAll();
	}
	
	@Override
	public Employee saveEntity(Employee entity) {
		return EmployeeeDAO.save(entity);
	}

	@Override
	public Employee getEntity(Long id) {
		return EmployeeeDAO.findOne(id);
	}

	@Override
	public Employee updateEntity(Employee entity) {
		return EmployeeeDAO.save(entity);
	}

	@Override
	public Employee deleteEntity(Long id) {
		return null;
	}
}
