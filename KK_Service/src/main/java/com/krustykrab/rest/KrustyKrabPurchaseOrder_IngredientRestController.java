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

import com.krustykrab.model.entities.PurchaseOrder_Ingredient;
import com.krustykrab.service.impl.KrustyKrabPurchaseOrder_IngredientServiceImpl;
import com.krustykrab.utils.CommonConstants;

@RequestMapping(path = "v1/purchaseorders_ingredients")
public class KrustyKrabPurchaseOrder_IngredientRestController {
	@Autowired
	private KrustyKrabPurchaseOrder_IngredientServiceImpl crudService;
	
	@GetMapping(value = CommonConstants.ID)
    public ResponseEntity<PurchaseOrder_Ingredient> getPurchaseOrder_Ingredient(@PathVariable Long id) {
		PurchaseOrder_Ingredient PurchaseOrder_Ingredient = crudService.getEntity(id);
		ResponseEntity<PurchaseOrder_Ingredient> responseEntity = new ResponseEntity<PurchaseOrder_Ingredient>(PurchaseOrder_Ingredient, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@GetMapping()
    public ResponseEntity<List<PurchaseOrder_Ingredient>> getPurchaseOrder_Ingredients() {
		List<PurchaseOrder_Ingredient> PurchaseOrder_Ingredients = crudService.getEntities();
		ResponseEntity<List<PurchaseOrder_Ingredient>> responseEntity = new ResponseEntity<List<PurchaseOrder_Ingredient>>(PurchaseOrder_Ingredients, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@PostMapping()
	public ResponseEntity<PurchaseOrder_Ingredient> savePurchaseOrder_Ingredient(@RequestBody PurchaseOrder_Ingredient PurchaseOrder_Ingredient) {
		PurchaseOrder_Ingredient responsePurchaseOrder_Ingredient = crudService.saveEntity(PurchaseOrder_Ingredient);
		ResponseEntity<PurchaseOrder_Ingredient> responseEntity = new ResponseEntity<PurchaseOrder_Ingredient>(responsePurchaseOrder_Ingredient, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(value = CommonConstants.ID)
	public ResponseEntity<PurchaseOrder_Ingredient> updatePurchaseOrder_Ingredient(@RequestBody PurchaseOrder_Ingredient PurchaseOrder_Ingredient) {
		PurchaseOrder_Ingredient responsePurchaseOrder_Ingredient = crudService.updateEntity(PurchaseOrder_Ingredient);
		ResponseEntity<PurchaseOrder_Ingredient> responseEntity = new ResponseEntity<PurchaseOrder_Ingredient>(responsePurchaseOrder_Ingredient, HttpStatus.OK);
		return responseEntity;
	}
}
