package com.krustykrab.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.krustykrab.model.entities.User;

public interface UserDAO extends CrudRepository<User, Long> {
	public User findByUserAndPassword(String user, String password);
}
