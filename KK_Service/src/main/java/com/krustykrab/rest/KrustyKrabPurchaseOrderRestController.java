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

import com.krustykrab.model.entities.PurchaseOrder;
import com.krustykrab.service.impl.KrustyKrabPurchaseOrderServiceImpl;
import com.krustykrab.utils.CommonConstants;

@RequestMapping(path = "v1/purchaseorders")
public class KrustyKrabPurchaseOrderRestController {
	@Autowired
	private KrustyKrabPurchaseOrderServiceImpl crudService;
	
	@GetMapping(value = CommonConstants.ID)
    public ResponseEntity<PurchaseOrder> getPurchaseOrder(@PathVariable Long id) {
		PurchaseOrder PurchaseOrder = crudService.getEntity(id);
		ResponseEntity<PurchaseOrder> responseEntity = new ResponseEntity<PurchaseOrder>(PurchaseOrder, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@GetMapping()
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrders() {
		List<PurchaseOrder> PurchaseOrders = crudService.getEntities();
		ResponseEntity<List<PurchaseOrder>> responseEntity = new ResponseEntity<List<PurchaseOrder>>(PurchaseOrders, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@PostMapping()
	public ResponseEntity<PurchaseOrder> savePurchaseOrder(@RequestBody PurchaseOrder PurchaseOrder) {
		PurchaseOrder responsePurchaseOrder = crudService.saveEntity(PurchaseOrder);
		ResponseEntity<PurchaseOrder> responseEntity = new ResponseEntity<PurchaseOrder>(responsePurchaseOrder, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(value = CommonConstants.ID)
	public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@RequestBody PurchaseOrder PurchaseOrder) {
		PurchaseOrder responsePurchaseOrder = crudService.updateEntity(PurchaseOrder);
		ResponseEntity<PurchaseOrder> responseEntity = new ResponseEntity<PurchaseOrder>(responsePurchaseOrder, HttpStatus.OK);
		return responseEntity;
	}
}
