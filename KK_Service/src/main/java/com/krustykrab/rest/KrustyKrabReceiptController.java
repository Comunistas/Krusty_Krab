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

import com.krustykrab.model.entities.Receipt;
import com.krustykrab.service.impl.KrustyKrabReceiptServiceImpl;
import com.krustykrab.utils.CommonConstants;

@RequestMapping("v1/receipts")
public class KrustyKrabReceiptController {
	@Autowired
	private KrustyKrabReceiptServiceImpl crudService;
	
	@GetMapping(value = CommonConstants.ID)
    public ResponseEntity<Receipt> getReceipt(@PathVariable Long id) {
		Receipt Receipt = crudService.getEntity(id);
		ResponseEntity<Receipt> responseEntity = new ResponseEntity<Receipt>(Receipt, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@GetMapping()
    public ResponseEntity<List<Receipt>> getReceipts() {
		List<Receipt> Receipts = crudService.getEntities();
		ResponseEntity<List<Receipt>> responseEntity = new ResponseEntity<List<Receipt>>(Receipts, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@PostMapping()
	public ResponseEntity<Receipt> saveReceipt(@RequestBody Receipt Receipt) {
		Receipt responseReceipt = crudService.saveEntity(Receipt);
		ResponseEntity<Receipt> responseEntity = new ResponseEntity<Receipt>(responseReceipt, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(value = CommonConstants.ID)
	public ResponseEntity<Receipt> updateReceipt(@RequestBody Receipt Receipt) {
		Receipt responseReceipt = crudService.updateEntity(Receipt);
		ResponseEntity<Receipt> responseEntity = new ResponseEntity<Receipt>(responseReceipt, HttpStatus.OK);
		return responseEntity;
	}
}
