package org.coffee.machine.maker;

import java.util.ArrayList;
import java.util.List;

import org.coffee.machine.abstractModel.Drink;
import org.coffee.machine.abstractModel.Order;
import org.coffee.machine.iCoffeeMachine.ICoffeMachine;
import org.coffee.machine.model.Chocolate;
import org.coffee.machine.model.Coffee;
import org.coffee.machine.model.HotChocolate;
import org.coffee.machine.model.HotCoffee;
import org.coffee.machine.model.HotTea;
import org.coffee.machine.model.InOrder;
import org.coffee.machine.model.InOrderUpdate;
import org.coffee.machine.model.Juice;
import org.coffee.machine.model.Tea;

public class DrinkMaker implements ICoffeMachine{
	
	private Order inOrder;
	private double price;
	public static List<Drink> report = new ArrayList<Drink>();

	public DrinkMaker(Order inOrder, double price) {
		super();
		this.inOrder = inOrder;
		this.price = price;
	}

	public DrinkMaker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drink makeDrink() {
		if(inOrder instanceof InOrder) {
			if(this.isEnoughOrMoreMoney(this.getPrice())) {
				if(((InOrder) this.inOrder).getDrink() == 'T') {
					System.out.println("Tea is maid");
					Drink tea = new Tea("Tea");
					report.add(tea);
					return tea;
				}
				
				if(((InOrder) this.inOrder).getDrink() == 'H') {
					System.out.println("Chocolate is maid");
					Drink chocolate = new Chocolate("Chocolate");
					report.add(chocolate);
					return chocolate;
				}
				
				if(((InOrder) this.inOrder).getDrink() == 'C') {
					System.out.println("Tea is maid");
					Drink coffee = new Coffee("Coffee");
					report.add(coffee);
					return coffee;
				}
			} else {
				System.out.println("Money is not enough ! Missing at least : "+this.atLeastMissing());				
			}
		} else {
			if(this.isEnoughOrMoreMoney(this.getPrice())) {
				if(this.inOrder.getDrinkUpdate().equalsIgnoreCase("O")) {
					System.out.println("Juice is maid");
					Drink juice = new Juice("Juice");
					report.add(juice);
					return juice;
				}
				
				if(this.inOrder.getDrinkUpdate().equalsIgnoreCase("Hh")) {
					System.out.println("Hot Chocolate is maid");
					Drink chocolate = new HotChocolate("Chocolate");
					report.add(chocolate);
					return chocolate;
				}
				
				if( this.inOrder.getDrinkUpdate().equalsIgnoreCase("Th")) {
					System.out.println("Hot Tea is maid");
					Drink tea = new HotTea("Tea");
					report.add(tea);
					return tea;
				}
				
				if(this.inOrder.getDrinkUpdate().equalsIgnoreCase("Ch")) {
					System.out.println("Hot Coffee is maid");
					Drink coffee = new HotCoffee("Coffeee");
					report.add(coffee);
					return coffee;
				}
			} else {
				System.out.println("Money is not enough ! Missing at least : "+this.atLeastMissing());
			}
		}
		return null;
	}

	private boolean isEnoughOrMoreMoney(double price) {
		if(inOrder instanceof InOrder) {
			if(this.inOrder.getDrink() == 'T' && price < 0.4)
				return false;
			if( this.inOrder.getDrink() == 'H' && price < 0.5)
				return false;
			if( this.inOrder.getDrink() == 'C' && price < 0.6)
				return false;
		} else {
			if( this.inOrder.getDrinkUpdate().equalsIgnoreCase("O") && price < 0.6)
				return false;
			if(this.inOrder.getDrinkUpdate().equalsIgnoreCase("Ch") && price < 0.6) 
				return false;
			if(this.inOrder.getDrinkUpdate().equalsIgnoreCase("Th") && price < 0.4)
				return false;
			if(this.inOrder.getDrinkUpdate().equalsIgnoreCase("Hh") && price < 0.5)
				return false;
		}	
		
		return true;
	}
	
	private double atLeastMissing() {
		double least = 0;
		
		if(this.inOrder instanceof InOrder) {
			if(((InOrder) this.inOrder).getDrink() == 'T')
				least = 0.4 - this.getPrice();
			if(((InOrder) this.inOrder).getDrink() == 'H')
				least = 0.5 - this.getPrice();
			if(((InOrder) this.inOrder).getDrink() == 'C')
				least = 0.6 - this.getPrice();
		} else {
			if(this.inOrder.getDrinkUpdate().equals("O"))
				least = 0.6 - this.getPrice();
			if(this.inOrder.getDrinkUpdate().equals("Hh"))
				least = 0.5 - this.getPrice();
			if(this.inOrder.getDrinkUpdate().equals("Ch"))
				least = 0.6 - this.getPrice();
			if(this.inOrder.getDrinkUpdate().equals("Th"))
				least = 0.5 - this.getPrice();
				
		}
		
		return least;
	}
	
	public void forwardsToCustomer() {
		System.out.println(this.inOrder);
	}

	public Order getInOrder() {
		return inOrder;
	}

	public void setInOrder(InOrder inOrder) {
		this.inOrder = inOrder;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public static void report() {
		if(report.isEmpty()) {
			System.out.println("Aucune commande passer aujourd'hui !");
		} else {
			double howMuchMoney = 0;
			
			for(Drink drink : report) {
				if(drink instanceof Tea) 
					howMuchMoney += 0.4;
				
				if(drink instanceof Coffee)
					howMuchMoney += 0.6;
				
				if(drink instanceof Chocolate)
					howMuchMoney += 0.5;
				
				if(drink instanceof Juice)
					howMuchMoney += 0.6;
				
				if(drink instanceof HotCoffee)
					howMuchMoney += 0.6;
				
				if(drink instanceof HotChocolate)
					howMuchMoney += 0.5;
				
				if(drink instanceof HotTea)
					howMuchMoney += 0.4;
				
			}
			
			System.out.println("Report : nombre de boissons vendu "+report.size()+", pour un montant de "+howMuchMoney);
		}
		
	}

}
