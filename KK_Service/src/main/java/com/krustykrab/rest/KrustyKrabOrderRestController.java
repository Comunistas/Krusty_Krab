package com.krustykrab.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.krustykrab.model.entities.Order;
import com.krustykrab.service.impl.KrustyKrabOrderServiceImpl;
import com.krustykrab.utils.CommonConstants;

public class KrustyKrabOrderRestController {
	@Autowired
	private KrustyKrabOrderServiceImpl crudService;
	
	@GetMapping(value = CommonConstants.ID)
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
		Order Order = crudService.getEntity(id);
		ResponseEntity<Order> responseEntity = new ResponseEntity<Order>(Order, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@GetMapping()
    public ResponseEntity<List<Order>> getOrders() {
		List<Order> Orders = crudService.getEntities();
		ResponseEntity<List<Order>> responseEntity = new ResponseEntity<List<Order>>(Orders, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@PostMapping()
	public ResponseEntity<Order> saveOrder(@RequestBody Order Order) {
		Order responseOrder = crudService.saveEntity(Order);
		ResponseEntity<Order> responseEntity = new ResponseEntity<Order>(responseOrder, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(value = CommonConstants.ID)
	public ResponseEntity<Order> updateOrder(@RequestBody Order Order) {
		Order responseOrder = crudService.updateEntity(Order);
		ResponseEntity<Order> responseEntity = new ResponseEntity<Order>(responseOrder, HttpStatus.OK);
		return responseEntity;
	}
}
