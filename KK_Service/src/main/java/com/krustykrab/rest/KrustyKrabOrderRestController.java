package com.krustykrab.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krustykrab.model.ShoppingCartResponse;
import com.krustykrab.model.entities.Dish;
import com.krustykrab.model.entities.Order;
import com.krustykrab.service.impl.KrustyKrabOrderServiceImpl;
import com.krustykrab.utils.CommonConstants;
import com.krustykrab.utils.ShoppingCartUtil;

@RestController
@RequestMapping(path="v1/order")
public class KrustyKrabOrderRestController {
	
	@Autowired private KrustyKrabOrderServiceImpl crudService;
	
	@Autowired private ShoppingCartUtil shoppingCartUtil;
	
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
	
	
	@GetMapping(path="/save/{tableId}")
	public ResponseEntity<String> saveOrder(@PathParam("tableId")long tableId) {
		shoppingCartUtil.saveOrder(tableId);
		return ResponseEntity.ok("Order saved.");
	}	

	@GetMapping(path="/new/{tableId}/{employeeId}")
	public ResponseEntity<String> createModifiableOrder(@PathVariable("tableId")long tableId,
	                                                    @PathVariable("employeeId")long employeeId){
		shoppingCartUtil.createANewOrder(tableId, employeeId);
		
		return ResponseEntity.ok("New order created");
	}
	
	@PostMapping(path="/add-dish/{tableId}")
	public ResponseEntity<ShoppingCartResponse> addDishToOrder(@RequestBody Dish dish,
	                                             @PathParam("tableId")long tableId){
		return ResponseEntity.ok(shoppingCartUtil.addDishToOrder(tableId, dish));
	}
	
	@GetMapping(path="/cart/{tableId}")
	public ResponseEntity<ShoppingCartResponse> getCart (@PathParam("tableId")long tableId){
		return ResponseEntity.ok(shoppingCartUtil.currentShoppingCart(tableId));
	}
}
