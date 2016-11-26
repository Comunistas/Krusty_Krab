package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.krustykrab.model.dao.TableDAO;
import com.krustykrab.model.entities.Table;
import com.krustykrab.service.KrustyKrabCrudService;

public class KrustyKrabTableServiceImpl implements KrustyKrabCrudService<Table>{
	@Autowired TableDAO TableeDAO;
	
	@Override
	public List<Table> getEntities() {
		return (List<Table>) TableeDAO.findAll();
	}
	
	@Override
	public Table saveEntity(Table entity) {
		return TableeDAO.save(entity);
	}

	@Override
	public Table getEntity(Long id) {
		return TableeDAO.findOne(id);
	}

	@Override
	public Table updateEntity(Table entity) {
		return TableeDAO.save(entity);
	}

	@Override
	public Table deleteEntity(Long id) {
		return null;
	}
}
