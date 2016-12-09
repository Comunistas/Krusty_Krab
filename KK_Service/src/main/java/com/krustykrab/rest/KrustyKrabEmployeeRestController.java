package com.krustykrab.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krustykrab.model.entities.Employee;
import com.krustykrab.service.impl.KrustyKrabEmployeeServiceImpl;

@RestController
@RequestMapping(path = "v1/employees")
public class KrustyKrabEmployeeRestController {
	@Autowired KrustyKrabEmployeeServiceImpl service;
	
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(){		
		return ResponseEntity.ok(service.getEntities());
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable long id){
		return ResponseEntity.ok(service.getEntity(id));
	}
}
