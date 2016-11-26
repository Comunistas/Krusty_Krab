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
public class KrustyKrabUserServiceImpl implements KrustyKrabCrudService<User>, KrustyKrabService{
	
	@Autowired
	UserDAO usuarioDAO;

		
	@Override
	public KrustyKrabValidateUserResponse validateUser(User user) {
		User usuarioValidado = usuarioDAO.findByUserAndPassword(user.getUser(), user.getPassword());
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
		return usuarioDAO.findOne(id);
	}



	@Override
	public List<User> getEntities() {
		return (List<User>)usuarioDAO.findAll();
	}



	@Override
	public User saveEntity(User entity) {
		return usuarioDAO.save(entity);
	}



	@Override
	public User updateEntity(User entity) {
		return usuarioDAO.save(entity);
	}



	@Override
	public User deleteEntity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
