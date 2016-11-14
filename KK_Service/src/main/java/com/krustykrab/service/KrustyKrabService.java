package com.krustykrab.service;

import java.util.List;

import com.krustykrab.model.KrustyKrabValidarUsuarioResponse;
import com.krustykrab.model.entities.Cliente;
import com.krustykrab.model.entities.Usuario;

public interface KrustyKrabService {

	public List<Cliente> getClientes();
	public Cliente saveCliente(Cliente cliente);
	public KrustyKrabValidarUsuarioResponse validarUsuario(Usuario usuario);
	
}
