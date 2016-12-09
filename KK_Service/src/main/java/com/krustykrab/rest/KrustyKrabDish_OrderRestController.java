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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krustykrab.model.entities.Dish_Order;
import com.krustykrab.model.entities.Order;
import com.krustykrab.service.impl.KrustyKrabDish_OrderServiceImpl;
import com.krustykrab.utils.CommonConstants;

@RestController
@RequestMapping(path = "v1/dishes-orders")
public class KrustyKrabDish_OrderRestController {
	
	@Autowired
	private KrustyKrabDish_OrderServiceImpl crudService;
	
	@GetMapping(value = CommonConstants.ID)
    public ResponseEntity<List<Dish_Order>> getDish_Order(@PathVariable Long id) {
		Order order = new Order();
		order.setId(id);
		
        return ResponseEntity.ok(crudService.getAllByOrder(order));
    }
	
	
	@GetMapping()
    public ResponseEntity<List<Dish_Order>> getDish_Orders() {
		List<Dish_Order> Dish_Orders = crudService.getEntities();
		ResponseEntity<List<Dish_Order>> responseEntity = new ResponseEntity<List<Dish_Order>>(Dish_Orders, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@PostMapping()
	public ResponseEntity<Dish_Order> saveDish_Order(@RequestBody Dish_Order Dish_Order) {
		Dish_Order responseDish_Order = crudService.saveEntity(Dish_Order);
		ResponseEntity<Dish_Order> responseEntity = new ResponseEntity<Dish_Order>(responseDish_Order, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(value = CommonConstants.ID)
	public ResponseEntity<Dish_Order> updateDish_Order(@RequestBody Dish_Order Dish_Order) {
		Dish_Order responseDish_Order = crudService.updateEntity(Dish_Order);
		ResponseEntity<Dish_Order> responseEntity = new ResponseEntity<Dish_Order>(responseDish_Order, HttpStatus.OK);
		return responseEntity;
	}
}
