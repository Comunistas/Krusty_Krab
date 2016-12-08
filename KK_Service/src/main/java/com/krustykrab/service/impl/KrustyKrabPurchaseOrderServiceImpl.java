package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krustykrab.model.dao.PurchaseOrderDAO;
import com.krustykrab.model.entities.PurchaseOrder;
import com.krustykrab.service.KrustyKrabCrudService;

@Service
public class KrustyKrabPurchaseOrderServiceImpl implements KrustyKrabCrudService<PurchaseOrder> {
	@Autowired PurchaseOrderDAO PurchaseOrdereDAO;
	
	@Override
	public List<PurchaseOrder> getEntities() {
		return (List<PurchaseOrder>) PurchaseOrdereDAO.findAll();
	}
	
	@Override
	public PurchaseOrder saveEntity(PurchaseOrder entity) {
		return PurchaseOrdereDAO.save(entity);
	}

	@Override
	public PurchaseOrder getEntity(Long id) {
		return PurchaseOrdereDAO.findOne(id);
	}

	@Override
	public PurchaseOrder updateEntity(PurchaseOrder entity) {
		return PurchaseOrdereDAO.save(entity);
	}

	@Override
	public PurchaseOrder deleteEntity(Long id) {
		return null;
	}
}
