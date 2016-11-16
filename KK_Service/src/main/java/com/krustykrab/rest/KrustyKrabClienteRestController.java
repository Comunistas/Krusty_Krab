package com.krustykrab.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krustykrab.model.entities.Client;
import com.krustykrab.service.KrustyKrabCrudService;
import com.krustykrab.service.impl.KrustyKrabClienteServiceImpl;
import com.krustykrab.utils.CommonConstants;

@RestController
@RequestMapping("/v1/clientes")
public class KrustyKrabClienteRestController {
	
	private KrustyKrabCrudService<Client> crudService = null;
	
	@Autowired
	public KrustyKrabClienteRestController(KrustyKrabClienteServiceImpl krabServiceImpl) {
		crudService = krabServiceImpl;
	}
	
	
	@GetMapping(value = CommonConstants.ID)
    public ResponseEntity<Client> getCliente(@PathVariable Long id) {
		Client cliente = crudService.getEntity(id);
		ResponseEntity<Client> responseEntity = new ResponseEntity<Client>(cliente, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@GetMapping()
    public ResponseEntity<List<Client>> getClientes() {
		List<Client> clientes = crudService.getEntities();
		ResponseEntity<List<Client>> responseEntity = new ResponseEntity<List<Client>>(clientes, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@PostMapping()
	public ResponseEntity<Client> saveCliente(@RequestBody Client cliente) {
		Client responseCliente = crudService.saveEntity(cliente);
		ResponseEntity<Client> responseEntity = new ResponseEntity<Client>(responseCliente, HttpStatus.OK);
		return responseEntity;
	}
}
