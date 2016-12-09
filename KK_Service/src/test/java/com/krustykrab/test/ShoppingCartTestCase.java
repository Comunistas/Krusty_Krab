package com.krustykrab.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.krustykrab.model.ShoppingCartResponse;
import com.krustykrab.model.entities.Dish;
import com.krustykrab.service.impl.KrustyKrabDishServiceImpl;
import com.krustykrab.service.impl.KrustyKrabOrderServiceImpl;
import com.krustykrab.utils.ShoppingCartUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(properties={"spring.jpa.properties.hibernate.hbm2ddl.import_files=mock-data.sql"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShoppingCartTestCase {

	@Autowired ShoppingCartUtil shoppingCartUtil;
	@Autowired KrustyKrabDishServiceImpl dishService;
	@Autowired KrustyKrabOrderServiceImpl orderService;
	
	/*
	@BeforeClass
	public static void loadData(){
		
	}*/
	
	@Before
	public void setUpACArt(){
		assertTrue(shoppingCartUtil.createANewOrder(1L, 1L));
	}
	
	
	/**
	 * This test is intended to test if the cart is actually being created,
	 * and a ShoppingCartResponse object is being created
	 */
	@Test
	public void test_01_AddNewOrder() {
		assertTrue(shoppingCartUtil.getAllCarts().stream().anyMatch(cart -> cart.getTableId()==1L));
		assertFalse(shoppingCartUtil.getAllCarts().stream().anyMatch(cart -> cart.getTableId()==1L));
	}
	
	@Test
	public void test_02_AddDishesToOrder() {
		
		Dish dish1 = dishService.getEntity(1L);
		Dish dish2 = dishService.getEntity(2L);
		
		
		shoppingCartUtil.addDishesToOrder(1L, dish1, 3);
		shoppingCartUtil.addDishesToOrder(1L, dish2, 1);
		
		ShoppingCartResponse cart = shoppingCartUtil.getShoppingCartForTable(1L);
		
		
	}
	
	/*
	@Test
	public void test_03_RemoveDishesToOrder() {
		assertTrue(shoppingCartUtil.createANewOrder(1L, 1L));
	}/*
	@Test
	public void test_04_DeleteCart() {
		assertTrue(shoppingCartUtil.createANewOrder(1L, 1L));
	}/*
	@Test
	public void test_05_SaveCart() {
		assertTrue(shoppingCartUtil.createANewOrder(1L, 1L));
	}*/
}
