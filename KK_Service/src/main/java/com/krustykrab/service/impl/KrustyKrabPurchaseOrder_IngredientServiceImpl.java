package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krustykrab.model.dao.PurchaseOrder_IngredientDAO;
import com.krustykrab.model.entities.PurchaseOrder_Ingredient;
import com.krustykrab.service.KrustyKrabCrudService;

@Service
public class KrustyKrabPurchaseOrder_IngredientServiceImpl implements KrustyKrabCrudService<PurchaseOrder_Ingredient> {
	@Autowired PurchaseOrder_IngredientDAO PurchaseOrder_IngredienteDAO;
	
	@Override
	public List<PurchaseOrder_Ingredient> getEntities() {
		return (List<PurchaseOrder_Ingredient>) PurchaseOrder_IngredienteDAO.findAll();
	}
	
	@Override
	public PurchaseOrder_Ingredient saveEntity(PurchaseOrder_Ingredient entity) {
		return PurchaseOrder_IngredienteDAO.save(entity);
	}

	@Override
	public PurchaseOrder_Ingredient getEntity(Long id) {
		return PurchaseOrder_IngredienteDAO.findOne(id);
	}

	@Override
	public PurchaseOrder_Ingredient updateEntity(PurchaseOrder_Ingredient entity) {
		return PurchaseOrder_IngredienteDAO.save(entity);
	}

	@Override
	public PurchaseOrder_Ingredient deleteEntity(Long id) {
		return null;
	}
}
