package org.coffee.machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.coffee.machine.abstractModel.Order;
import org.coffee.machine.maker.DrinkMaker;
import org.coffee.machine.model.Chocolate;
import org.coffee.machine.model.Coffee;
import org.coffee.machine.model.HotChocolate;
import org.coffee.machine.model.HotCoffee;
import org.coffee.machine.model.HotTea;
import org.coffee.machine.model.InOrder;
import org.coffee.machine.model.InOrderUpdate;
import org.coffee.machine.model.Juice;
import org.coffee.machine.model.Tea;
import org.junit.Test;

public class DrinkMakerTest {
	
	@Test
	public void testEnoughMoneyForTea() {
		Order order1 = new InOrder('T', 2, 1);
		DrinkMaker drinkMaker = new DrinkMaker(order1, 0.3);
		
		assertNull(drinkMaker.makeDrink());
	}
	
	@Test
	public void testEnoughMoneyForCoffee() {
		Order order1 = new InOrder('C', 2, 1);
		DrinkMaker drinkMaker = new DrinkMaker(order1, 0.3);
		
		assertNull(drinkMaker.makeDrink());
	}
	
	@Test
	public void testEnoughMoneyForChocolate() {
		Order order1 = new InOrder('H', 2, 1);
		DrinkMaker drinkMaker = new DrinkMaker(order1, 0.3);
		
		assertNull(drinkMaker.makeDrink());
	}
	
	@Test 
	public void testEnoughMoneyForJuice() {
		Order order1 = new InOrderUpdate("O", 2, 1);
		DrinkMaker drinkMaker = new DrinkMaker(order1, 0.2);
		
		assertNull(drinkMaker.makeDrink());
	}
	
	@Test
	public void testOrderTea() {
		Order order = new InOrder('T', 2, 1);
		DrinkMaker maker = new DrinkMaker(order, 0.7);
		
		assertTrue(maker.makeDrink() instanceof Tea);
	}
	
	@Test
	public void testOrderCoffee() {
		Order order = new InOrder('C', 2, 1);
		DrinkMaker maker = new DrinkMaker(order, 0.7);
		
		assertTrue(maker.makeDrink() instanceof Coffee);
	}
	
	@Test
	public void testOrderChocolate() {
		Order order = new InOrder('H', 2, 1);
		DrinkMaker maker = new DrinkMaker(order, 0.7);
		
		assertTrue(maker.makeDrink() instanceof Chocolate);
	}
	
	@Test 
	public void testOrderJuice() {
		Order order = new InOrderUpdate("O", 2, 1);
		DrinkMaker maker = new DrinkMaker(order, 0.7);
		
		assertTrue(maker.makeDrink() instanceof Juice);
	}
	
	@Test
	public void testOrderHCoffee() {
		Order order = new InOrderUpdate("Ch", 2, 1);
		DrinkMaker maker = new DrinkMaker(order, 0.7);
		
		assertTrue(maker.makeDrink() instanceof HotCoffee);
	}
	
	@Test
	public void testOrderHTea() {
		Order order = new InOrderUpdate("Th", 2, 1);
		DrinkMaker maker = new DrinkMaker(order, 0.7);
		
		assertTrue(maker.makeDrink() instanceof HotTea);
	}
	
	@Test
	public void testOrderHChocolate() {
		Order order = new InOrderUpdate("Hh", 2, 1);
		DrinkMaker maker = new DrinkMaker(order, 0.7);
		
		assertTrue(maker.makeDrink() instanceof HotChocolate);
	}
	
	@Test
	public void testReport() {
		Order order1 = new InOrder('C', 2, 1);
		DrinkMaker drinkMaker = new DrinkMaker(order1, 0.7);
		drinkMaker.makeDrink();
		
		Order order2 = new InOrder('C', 2, 1);
		DrinkMaker drinkMaker2 = new DrinkMaker(order2, 0.7);
		drinkMaker2.makeDrink();
		
		Order order3 = new InOrder('H', 2, 1);
		DrinkMaker drinkMaker3 = new DrinkMaker(order3, 0.7);
		drinkMaker3.makeDrink();
		
		Order order4 = new InOrder('T', 2, 1);
		DrinkMaker drinkMaker4 = new DrinkMaker(order4, 0.7);
		drinkMaker4.makeDrink();
		
		Order order5 = new InOrderUpdate("O", 2, 1);
		DrinkMaker drinkMaker5 = new DrinkMaker(order5, 0.7);
		drinkMaker5.makeDrink();
		
		DrinkMaker.report();
		
		assertEquals(DrinkMaker.report.size(), 10);
	}
}
