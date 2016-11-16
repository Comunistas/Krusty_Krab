package com.krustykrab.service;

import com.krustykrab.model.KrustyKrabValidateUserResponse;
import com.krustykrab.model.entities.User;

public interface KrustyKrabService {
	public KrustyKrabValidateUserResponse validarUsuario(User usuario);
}
