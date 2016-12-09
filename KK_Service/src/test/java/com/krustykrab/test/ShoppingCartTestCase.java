package com.krustykrab.test;

import static org.junit.Assert.*;


import java.util.Collection;
import java.util.List;

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
import com.krustykrab.model.entities.Dish_Order;
import com.krustykrab.model.entities.Order;
import com.krustykrab.service.impl.KrustyKrabDishServiceImpl;
import com.krustykrab.service.impl.KrustyKrabDish_OrderServiceImpl;
import com.krustykrab.service.impl.KrustyKrabOrderServiceImpl;
import com.krustykrab.utils.ShoppingCartUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShoppingCartTestCase {

	@Autowired ShoppingCartUtil shoppingCartUtil;
	@Autowired KrustyKrabDishServiceImpl dishService;
	@Autowired KrustyKrabOrderServiceImpl orderService;
	@Autowired KrustyKrabDish_OrderServiceImpl dishOrderService;
	
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
	
	private void addTwoDishesToCart() {
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
		
		addTwoDishesToCart();
		
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
		
		addTwoDishesToCart();
		
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
	 * Test that there's no repeated cart for a single table.
	 */
	@Test
	public void test_05_RepeatedCart(){
		
		assertFalse(shoppingCartUtil.createANewOrder(1L, 1L));
		assertTrue(shoppingCartUtil.createANewOrder(2L, 1L));
		assertFalse(shoppingCartUtil.createANewOrder(2L, 1L));
		shoppingCartUtil.deleteOrder(2L);
	}
	
	
	/**
	 * Check that the order is being saved succefully and saved to the database, as well as it's detail.
	 */
	@Test
	public void test_06_SaveCart() {
		addTwoDishesToCart();
		shoppingCartUtil.saveOrder(tableId);
		
		assertTrue(shoppingCartUtil.getAllCarts().isEmpty());
		
		Order order = orderService.getEntity(1L);
		
		assertNotNull(order);
		
		assertTrue(order.getEmployee().getId() == 1L);
		
		List<Dish_Order> dishOrders = dishOrderService.getAllByOrder(order);
		
		Dish_Order dishOrder1 = dishOrders.stream().filter(dishOrder -> dishOrder.getDish().getId()==firstDishId).findFirst().get();
		Dish_Order dishOrder2 = dishOrders.stream().filter(dishOrder -> dishOrder.getDish().getId()==secondDishId).findFirst().get();
		
		assertEquals(5, dishOrder1.getAmount());
		assertEquals(2, dishOrder2.getAmount());
		
	}
}
