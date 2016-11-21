package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.Ingredient;

@Transactional
public interface IngredientDAO extends CrudRepository<Ingredient, Long> {

}
