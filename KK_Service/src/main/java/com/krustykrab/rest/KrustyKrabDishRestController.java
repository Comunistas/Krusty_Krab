/**
 * 
 */
package com.krustykrab.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krustykrab.model.SuccessResponse;
import com.krustykrab.model.entities.Dish;
import com.krustykrab.service.impl.KrustyKrabDishServiceImpl;

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
	
	@GetMapping(path="/delete")
	public ResponseEntity<SuccessResponse> deleteDish(@PathParam("id")long id){
		service.deleteEntity(id);
		return ResponseEntity.ok(new SuccessResponse());
	}
	
	@PostMapping
	public ResponseEntity<Dish> saveDish(@RequestBody Dish dish){
		return ResponseEntity.ok(service.saveEntity(dish));
	}
}
