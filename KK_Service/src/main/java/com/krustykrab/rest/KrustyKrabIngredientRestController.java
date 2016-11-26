package com.krustykrab.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krustykrab.model.entities.Ingredient;
import com.krustykrab.service.impl.KrustyKrabIngredientServiceImpl;

@RequestMapping(path = "v1/ingredients")
public class KrustyKrabIngredientRestController {
	@Autowired KrustyKrabIngredientServiceImpl service;
	
	
	@GetMapping
	public ResponseEntity<List<Ingredient>> getIngredients(){		
		return ResponseEntity.ok(service.getEntities());
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Ingredient> getIngredient(@PathVariable long id){
		return ResponseEntity.ok(service.getEntity(id));
	}
}
