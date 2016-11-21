package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.krustykrab.model.entities.PurchaseOrder_Ingredient;

@Transactional
public interface PurchaseOrder_IngredientDAO extends CrudRepository<PurchaseOrder_Ingredient, Long> {

}
