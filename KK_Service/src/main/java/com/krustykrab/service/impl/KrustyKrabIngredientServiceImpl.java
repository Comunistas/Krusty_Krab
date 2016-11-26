package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.krustykrab.model.dao.IngredientDAO;
import com.krustykrab.model.entities.Ingredient;
import com.krustykrab.service.KrustyKrabCrudService;

public class KrustyKrabIngredientServiceImpl implements KrustyKrabCrudService<Ingredient>{
	@Autowired IngredientDAO IngredienteDAO;
	
	@Override
	public List<Ingredient> getEntities() {
		return (List<Ingredient>) IngredienteDAO.findAll();
	}
	
	@Override
	public Ingredient saveEntity(Ingredient entity) {
		return IngredienteDAO.save(entity);
	}

	@Override
	public Ingredient getEntity(Long id) {
		return IngredienteDAO.findOne(id);
	}

	@Override
	public Ingredient updateEntity(Ingredient entity) {
		return IngredienteDAO.save(entity);
	}

	@Override
	public Ingredient deleteEntity(Long id) {
		return null;
	}
}
