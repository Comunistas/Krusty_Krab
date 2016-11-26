package com.krustykrab.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krustykrab.model.entities.Ingredient_Dish;
import com.krustykrab.service.impl.KrustyKrabIngredient_DishServiceImpl;

@RequestMapping(path = "v1/ingredients_dishes")
public class KrustyKrabIngredient_DishRestController {
	@Autowired KrustyKrabIngredient_DishServiceImpl service;
	
	
	@GetMapping
	public ResponseEntity<List<Ingredient_Dish>> getIngredients_Dishes(){		
		return ResponseEntity.ok(service.getEntities());
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Ingredient_Dish> getIngredient_Dish(@PathVariable long id){
		return ResponseEntity.ok(service.getEntity(id));
	}
}
