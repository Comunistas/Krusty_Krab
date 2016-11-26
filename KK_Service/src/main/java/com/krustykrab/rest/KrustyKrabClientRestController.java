package com.krustykrab.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krustykrab.model.entities.Client;
import com.krustykrab.service.impl.KrustyKrabClientServiceImpl;
import com.krustykrab.utils.CommonConstants;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/v1/clientes")
public class KrustyKrabClientRestController {
	@Autowired
	private KrustyKrabClientServiceImpl crudService;
	
	@GetMapping(value = CommonConstants.ID)
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
		Client client = crudService.getEntity(id);
		ResponseEntity<Client> responseEntity = new ResponseEntity<Client>(client, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@GetMapping()
    public ResponseEntity<List<Client>> getClients() {
		List<Client> clients = crudService.getEntities();
		ResponseEntity<List<Client>> responseEntity = new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@PostMapping()
	public ResponseEntity<Client> saveClient(@RequestBody Client client) {
		Client responseClient = crudService.saveEntity(client);
		ResponseEntity<Client> responseEntity = new ResponseEntity<Client>(responseClient, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(value = CommonConstants.ID)
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {
		Client responseClient = crudService.updateEntity(client);
		ResponseEntity<Client> responseEntity = new ResponseEntity<Client>(responseClient, HttpStatus.OK);
		return responseEntity;
	}
}
