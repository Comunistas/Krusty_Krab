package com.krustykrab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krustykrab.model.KrustyKrabValidateUserResponse;
import com.krustykrab.model.dao.UserDAO;
import com.krustykrab.model.entities.User;
import com.krustykrab.service.KrustyKrabCrudService;
import com.krustykrab.service.KrustyKrabService;

@Service
public class KrustyKrabUsuarioServiceImpl implements KrustyKrabCrudService<User>, KrustyKrabService{
	
	@Autowired
	UserDAO usuarioDAO;

		
	@Override
	public KrustyKrabValidateUserResponse validarUsuario(User usuario) {
		User usuarioValidado = usuarioDAO.findByUserAndPassword(usuario.getUser(), usuario.getPassword());
		KrustyKrabValidateUserResponse response = null;
		
		
		if(usuarioValidado != null) {
			response = new KrustyKrabValidateUserResponse(true, usuarioValidado);
		} else {
			response = new KrustyKrabValidateUserResponse(false, null);
		}
		return response;
	}



	@Override
	public User getEntity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<User> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User saveEntity(User entity) {
		return usuarioDAO.save(entity);
	}



	@Override
	public User updateEntity(User entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User deleteEntity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
