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

import com.krustykrab.model.KrustyKrabValidateUserResponse;
import com.krustykrab.model.entities.User;
import com.krustykrab.service.impl.KrustyKrabUserServiceImpl;
import com.krustykrab.utils.CommonConstants;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/v1/usuarios")
public class KrustyKrabUserRestController {
	
	@Autowired
	private KrustyKrabUserServiceImpl service;
	
	
	@PostMapping(value = "/login")
	public ResponseEntity<KrustyKrabValidateUserResponse> validarUser(@RequestBody User user) {
		KrustyKrabValidateUserResponse response = service.validateUser(user);
		ResponseEntity<KrustyKrabValidateUserResponse> responseEntity = 
				new ResponseEntity<KrustyKrabValidateUserResponse>(response, HttpStatus.OK);
		return responseEntity;
	}
	
	
	@GetMapping(value = CommonConstants.ID)
    public ResponseEntity<User> getUser(@PathVariable Long id) {
		User User = service.getEntity(id);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(User, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@GetMapping()
    public ResponseEntity<List<User>> getUsers() {
		List<User> Users = service.getEntities();
		ResponseEntity<List<User>> responseEntity = new ResponseEntity<List<User>>(Users, HttpStatus.OK);
        return responseEntity;
    }
	
	
	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User User) {
		User responseUser = service.saveEntity(User);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(responseUser, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(value = CommonConstants.ID)
	public ResponseEntity<User> updateUser(@RequestBody User User) {
		User responseUser = service.updateEntity(User);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(responseUser, HttpStatus.OK);
		return responseEntity;
	}
}
