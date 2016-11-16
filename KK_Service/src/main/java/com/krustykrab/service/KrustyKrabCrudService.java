package com.krustykrab.service;

import java.util.List;

public interface KrustyKrabCrudService<T> {

	public T getEntity(Long id);
	public List<T> getEntities();
	public T saveEntity(T entity);
	public T updateEntity(T entity);
	public T deleteEntity(Long id);
	
}
