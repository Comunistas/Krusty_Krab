package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krustykrab.model.dao.Ingredient_DishDAO;
import com.krustykrab.model.entities.Ingredient_Dish;
import com.krustykrab.service.KrustyKrabCrudService;

@Service
public class KrustyKrabIngredient_DishServiceImpl implements KrustyKrabCrudService<Ingredient_Dish> {
	@Autowired Ingredient_DishDAO Ingredient_DisheDAO;
	
	@Override
	public List<Ingredient_Dish> getEntities() {
		return (List<Ingredient_Dish>) Ingredient_DisheDAO.findAll();
	}
	
	@Override
	public Ingredient_Dish saveEntity(Ingredient_Dish entity) {
		return Ingredient_DisheDAO.save(entity);
	}

	@Override
	public Ingredient_Dish getEntity(Long id) {
		return Ingredient_DisheDAO.findOne(id);
	}

	@Override
	public Ingredient_Dish updateEntity(Ingredient_Dish entity) {
		return Ingredient_DisheDAO.save(entity);
	}

	@Override
	public Ingredient_Dish deleteEntity(Long id) {
		return null;
	}
}
