package com.krustykrab.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krustykrab.model.ShoppingCartResponse;
import com.krustykrab.model.SuccessResponse;
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
	
	
	@GetMapping(path="/new/{tableId}/{employeeId}")
	public ResponseEntity<SuccessResponse> createModifiableOrder(@PathVariable("tableId")Long tableId,
	                                                             @PathVariable("employeeId")Long employeeId){		
		return ResponseEntity.ok(new SuccessResponse(shoppingCartUtil.createANewOrder(tableId, employeeId)));
	}
	
	@PostMapping(path="/add-dish/{tableId}")
	public ResponseEntity<ShoppingCartResponse> addDishesToOrder(@RequestBody Dish dish,
	                                                             @PathVariable("tableId")Long tableId,
	                                                             @RequestParam("amount")Integer amount){
		System.out.println(dish.getDescription());
		System.out.println(tableId);
		return ResponseEntity.ok(shoppingCartUtil.addDishesToOrder(tableId, dish, amount));
	}
	
	@GetMapping(path="/remove-dish/{tableId}/{dishId}")
	public ResponseEntity<SuccessResponse> removeDishesFromOrder(@PathVariable("tableId")Long tableId,
	                                                           @PathVariable("dishId")Long dishId,
	                                                           @RequestParam("amount")Integer amount){
		shoppingCartUtil.removeDishesFromOrder(tableId, dishId, amount);
		return ResponseEntity.ok(new SuccessResponse());
	}

	
	@GetMapping(path="/save/{tableId}")
	public ResponseEntity<String> saveOrder(@PathVariable("tableId")Long tableId) {
		shoppingCartUtil.saveOrder(tableId);
		return ResponseEntity.ok("Order saved.");
	}	
	
	@GetMapping(path="/delete/{tableId}")
	public ResponseEntity<List<ShoppingCartResponse>> deleteOrder(@PathVariable("tableId")Long tableId) {
		return ResponseEntity.ok(shoppingCartUtil.deleteOrder(tableId));
	}	

	@GetMapping(path="/cart/{tableId}")
	public ResponseEntity<ShoppingCartResponse> getCart (@PathVariable("tableId")Long tableId){
		return ResponseEntity.ok(shoppingCartUtil.currentShoppingCart(tableId));
	}
	
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
	
	

}
