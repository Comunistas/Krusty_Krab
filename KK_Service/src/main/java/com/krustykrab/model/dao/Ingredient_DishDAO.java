package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.Ingredient_Dish;

@Transactional
public interface Ingredient_DishDAO extends CrudRepository<Ingredient_Dish, Long> {

}
