package com.krustykrab.model;

import com.krustykrab.model.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KrustyKrabValidateUserResponse {
	private boolean authenticated;
	private User user;
}
