package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.krustykrab.model.dao.ReceiptDAO;
import com.krustykrab.model.entities.Receipt;
import com.krustykrab.service.KrustyKrabCrudService;

public class KrustyKrabReceiptServiceImpl implements KrustyKrabCrudService<Receipt> {
	@Autowired ReceiptDAO ReceipteDAO;
	
	@Override
	public List<Receipt> getEntities() {
		return (List<Receipt>) ReceipteDAO.findAll();
	}
	
	@Override
	public Receipt saveEntity(Receipt entity) {
		return ReceipteDAO.save(entity);
	}

	@Override
	public Receipt getEntity(Long id) {
		return ReceipteDAO.findOne(id);
	}

	@Override
	public Receipt updateEntity(Receipt entity) {
		return ReceipteDAO.save(entity);
	}

	@Override
	public Receipt deleteEntity(Long id) {
		return null;
	}
}
