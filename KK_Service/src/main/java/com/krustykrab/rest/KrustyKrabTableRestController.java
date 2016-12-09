package com.krustykrab.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krustykrab.model.entities.Table;
import com.krustykrab.service.impl.KrustyKrabTableServiceImpl;

@RestController
@RequestMapping(path = "v1/tables")
public class KrustyKrabTableRestController {
	@Autowired KrustyKrabTableServiceImpl service;
	
	
	@GetMapping
	public ResponseEntity<List<Table>> getTables(){		
		return ResponseEntity.ok(service.getEntities());
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Table> getTable(@PathVariable long id){
		return ResponseEntity.ok(service.getEntity(id));
	}
}
