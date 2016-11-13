package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.krustykrab.model.entities.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Long> {
	public Usuario findByUsuarioAndPassword(String usuario, String password);
}
