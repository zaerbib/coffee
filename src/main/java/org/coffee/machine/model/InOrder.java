/**
 * "T:1:0" (Drink maker makes 1 tea with 1 sugar and a stick)
 * "H::" (Drink maker makes 1 chocolate with no sugar - and therefore no stick)
 * "C:2:0" (Drink maker makes 1 coffee with 2 sugars and a stick)
 * "M:message-content" (Drink maker forwards any message received onto the coffee machine interface for the customer to see)				
 */

package org.coffee.machine.model;

import org.coffee.machine.abstractModel.Order;

public class InOrder extends Order{
	public char drink;
	public int nbSugar;
	public int nbStick;
			
	public InOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InOrder(char drink, int nbSugar, int nbStick) {
		super();
		this.drink = drink;
		this.nbSugar = nbSugar;
		this.nbStick = nbStick;
	}
	
	public char getDrink() {
		return drink;
	}
	public void setDrink(char drink) {
		this.drink = drink;
	}
	public int getNbSugar() {
		return nbSugar;
	}
	public void setNbSugar(int nbSugar) {
		this.nbSugar = nbSugar;
	}
	public int getNbStick() {
		return nbStick;
	}
	public void setNbStick(int nbStick) {
		this.nbStick = nbStick;
	}
	
	
}
