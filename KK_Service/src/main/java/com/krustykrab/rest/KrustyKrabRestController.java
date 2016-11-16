package com.krustykrab.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krustykrab.model.KrustyKrabValidarUsuarioResponse;
import com.krustykrab.model.entities.Cliente;
import com.krustykrab.model.entities.Usuario;
import com.krustykrab.service.KrustyKrabService;
import com.krustykrab.service.impl.KrustyKrabServiceImpl;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/v1")
public class KrustyKrabRestController {
	
	private KrustyKrabService service = null;
	
	@Autowired
	public KrustyKrabRestController(KrustyKrabServiceImpl krabServiceImpl) {
		service = krabServiceImpl;
	}
	
	
	@PostMapping("/usuarios/login")
	public ResponseEntity<KrustyKrabValidarUsuarioResponse> validarUsuario(@RequestBody Usuario usuario) {
		KrustyKrabValidarUsuarioResponse response = service.validarUsuario(usuario);
		ResponseEntity<KrustyKrabValidarUsuarioResponse> responseEntity = 
				new ResponseEntity<KrustyKrabValidarUsuarioResponse>(response, HttpStatus.OK);
		return responseEntity;
	}
	
	
	@GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> clientes = service.getClientes();
		ResponseEntity<List<Cliente>> responseEntity = new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
        return responseEntity;
    }
	
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
		Cliente responseCliente = service.saveCliente(cliente);
		ResponseEntity<Cliente> responseEntity = new ResponseEntity<Cliente>(responseCliente, HttpStatus.OK);
		return responseEntity;
	}
}
