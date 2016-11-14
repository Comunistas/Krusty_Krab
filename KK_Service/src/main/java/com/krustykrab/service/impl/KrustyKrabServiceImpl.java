package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krustykrab.model.KrustyKrabValidarUsuarioResponse;
import com.krustykrab.model.dao.ClienteDAO;
import com.krustykrab.model.dao.UsuarioDAO;
import com.krustykrab.model.entities.Cliente;
import com.krustykrab.model.entities.Usuario;
import com.krustykrab.service.KrustyKrabService;

@Service
public class KrustyKrabServiceImpl implements KrustyKrabService {

	@Autowired ClienteDAO clienteDAO;
	@Autowired UsuarioDAO usuarioDAO;
	
	@Override
	public List<Cliente> getClientes() {
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteDAO.save(cliente);
	}

	@Override
	public KrustyKrabValidarUsuarioResponse validarUsuario(Usuario usuario) {
		Usuario usuarioValidado = usuarioDAO.findByUsuarioAndPassword(usuario.getUsuario(), usuario.getPassword());
		KrustyKrabValidarUsuarioResponse response = null;
		if(usuarioValidado != null) {
			response = new KrustyKrabValidarUsuarioResponse(true, usuarioValidado);
		} else {
			response = new KrustyKrabValidarUsuarioResponse(false, null);
		}
		return response;
	}
	
}
