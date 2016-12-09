package com.krustykrab.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
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
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShoppingCartTestCase {

	@Autowired ShoppingCartUtil shoppingCartUtil;
	@Autowired KrustyKrabDishServiceImpl dishService;
	@Autowired KrustyKrabOrderServiceImpl orderService;
	
	long tableId = 1L;
	long firstDishId = 1L;
	long secondDishId = 2L;
	
	/*
	@BeforeClass
	public static void loadData(){
		
	}*/
	
	@Before
	public void setUpACArt(){
		assertTrue(shoppingCartUtil.createANewOrder(1L, 1L));
	}
	
	@After
	public void destroyCart(){
		shoppingCartUtil.deleteOrder(1L);
	}
	
	private void addTwoCarts() {
		Dish dish1 = dishService.getEntity(firstDishId);
		Dish dish2 = dishService.getEntity(secondDishId);
		
		shoppingCartUtil.addDishesToOrder(tableId, dish1, 5);
		shoppingCartUtil.addDishesToOrder(tableId, dish2, 2);
	}
	
	
	/**
	 * This test is intended to check if the cart is actually being created,
	 * and a ShoppingCartResponse object is being created
	 */
	@Test
	public void test_01_AddNewOrder() {
		assertTrue(shoppingCartUtil.getAllCarts().stream().anyMatch(cart -> cart.getTableId()==tableId));
		assertFalse(shoppingCartUtil.getAllCarts().stream().anyMatch(cart -> cart.getTableId()==2L));
	}
	
	/**
	 * This test is intended to validate that the dishes are being added succefully to the cart.
	 */
	@Test
	public void test_02_AddDishesToOrder() {
		
		addTwoCarts();
		
		ShoppingCartResponse cart = shoppingCartUtil.getShoppingCartForTable(tableId);
		
		assertFalse(cart.getDishes().isEmpty());
	
		assertEquals(5, cart.getDishes().stream().filter(dishOrder -> dishOrder.getDish().getId() == firstDishId).findFirst().get().getAmount());
		assertEquals(2,cart.getDishes().stream().filter(dishOrder -> dishOrder.getDish().getId() == secondDishId).findFirst().get().getAmount());
		
	}
	
	
	/**
	 * This test is intended to check that the dishes are being removed correctly from the cart.
	 */
	@Test
	public void test_03_RemoveDishesToOrder() {
		
		addTwoCarts();
		
		ShoppingCartResponse cart;
		
		// 5 - 3 dishes
		cart = shoppingCartUtil.removeDishesFromOrder(tableId, firstDishId, 3);
		
		assertEquals(2, cart.getDishes().stream().filter(dishOrder -> dishOrder.getDish().getId() == firstDishId).findFirst().get().getAmount());

		// 2 - 2 dishes, the dish item should be removed
		cart = shoppingCartUtil.removeDishesFromOrder(tableId, secondDishId, 2);
		
		assertFalse(cart.getDishes().stream().anyMatch(dishOrder -> dishOrder.getDish().getId() == secondDishId));
		
	}
	
	
	
	/**
	 * This test checks if the entire cart is deleted for a table.
	 */
	@Test
	public void test_04_DeleteCart() {
		
		Collection<ShoppingCartResponse> carts = shoppingCartUtil.deleteOrder(tableId);
		
		//Since there was only one cart in the cache, the list should be empty
		assertTrue(carts.isEmpty());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void test_05_RepeatedCart(){
		
		assertFalse(shoppingCartUtil.createANewOrder(1L, 1L));
		assertTrue(shoppingCartUtil.createANewOrder(2L, 1L));
		assertFalse(shoppingCartUtil.createANewOrder(2L, 1L));
		shoppingCartUtil.deleteOrder(2L);
	}
	
	
	@Test
	public void test_06_SaveCart() {
		
	}
}
