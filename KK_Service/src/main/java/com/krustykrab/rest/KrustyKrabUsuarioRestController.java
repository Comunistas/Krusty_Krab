package com.krustykrab.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krustykrab.model.KrustyKrabValidateUserResponse;
import com.krustykrab.model.entities.User;
import com.krustykrab.service.KrustyKrabCrudService;
import com.krustykrab.service.KrustyKrabService;
import com.krustykrab.service.impl.KrustyKrabUsuarioServiceImpl;

@RestController
@RequestMapping("/v1/usuarios")
public class KrustyKrabUsuarioRestController {
	
	private KrustyKrabCrudService<User> crudService = null;
	private KrustyKrabService service = null;
	
	@Autowired
	public KrustyKrabUsuarioRestController(KrustyKrabUsuarioServiceImpl krabCrudServiceImpl, KrustyKrabService krabService) {
		crudService = krabCrudServiceImpl;
		service = krabService;
	}
	
	
	@PostMapping()
	public ResponseEntity<User> saveUsuario(@RequestBody User usuario) {
		User savedUser = crudService.saveEntity(usuario);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(savedUser, HttpStatus.OK);
		return responseEntity;
	}
	
	
	@PostMapping(value = "/login")
	public ResponseEntity<KrustyKrabValidateUserResponse> validarUsuario(@RequestBody User usuario) {
		KrustyKrabValidateUserResponse response = service.validarUsuario(usuario);
		ResponseEntity<KrustyKrabValidateUserResponse> responseEntity = 
				new ResponseEntity<KrustyKrabValidateUserResponse>(response, HttpStatus.OK);
		return responseEntity;
	}
}
