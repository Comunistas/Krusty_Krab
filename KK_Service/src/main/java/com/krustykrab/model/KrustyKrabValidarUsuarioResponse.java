package com.krustykrab.model;

import com.krustykrab.model.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KrustyKrabValidarUsuarioResponse {
	private boolean authenticated;
	private Usuario usuario;
}
