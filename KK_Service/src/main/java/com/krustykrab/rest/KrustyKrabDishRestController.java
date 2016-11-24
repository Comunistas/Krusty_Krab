/**
 * 
 */
package com.krustykrab.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krustykrab.model.entities.Dish;
import com.krustykrab.service.impl.KrustyKrabDishServiceImpl;

/**
 * @author Vladislav Zedano
 *
 */
@RestController
@RequestMapping(path="v1/dishes")
public class KrustyKrabDishRestController
{
	@Autowired KrustyKrabDishServiceImpl service;
	
	
	@GetMapping
	public ResponseEntity<List<Dish>> getDishes(){		
		return ResponseEntity.ok(service.getEntities());
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Dish> getDish(@PathVariable long id){
		return ResponseEntity.ok(service.getEntity(id));
	}
}
