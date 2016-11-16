package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.Client;

@Transactional
public interface Ingredient_DishDAO extends CrudRepository<Client, Long> {

}
