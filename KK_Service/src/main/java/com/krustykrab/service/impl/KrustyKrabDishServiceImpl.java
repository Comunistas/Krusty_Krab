/**
 * 
 */
package com.krustykrab.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krustykrab.model.dao.DishDAO;
import com.krustykrab.model.entities.Dish;
import com.krustykrab.service.KrustyKrabCrudService;

/**
 * @author Vladislav Zedano
 *
 */
@Service
public class KrustyKrabDishServiceImpl implements KrustyKrabCrudService<Dish>
{

	@Autowired DishDAO dao;
	
	@Override
	public Dish getEntity(Long id)
	{
		return dao.findOne(id);
	}

	@Override
	public List<Dish> getEntities()
	{
		List<Dish> dishes = new ArrayList<Dish>();
		Iterator<Dish> dishesIterator = dao.findAll().iterator();
		
		while(dishesIterator.hasNext()){
			dishes.add(dishesIterator.next());
		}
		
		return dishes;
	}


	@Override
	public Dish saveEntity(Dish entity)
	{
		return dao.save(entity);
	}

	@Override
	public Dish updateEntity(Dish entity)
	{
		return dao.save(entity);
	}


	@Override
	public Dish deleteEntity(Long id)
	{
		dao.delete(id);
		return null;
	}
	
}
