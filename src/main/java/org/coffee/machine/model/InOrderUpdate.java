/**
 * "O::" (Drink maker will make one orange juice)
 * "Ch::" (Drink maker will make an extra hot coffee with no sugar)
 * "Hh:1:0" (Drink maker will make an extra hot chocolate with one sugar and a stick)
 * "Th:2:0" (The drink maker will make an extra hot tea with two sugar and a stick)
 */
package org.coffee.machine.model;

import org.coffee.machine.abstractModel.Order;

/**
 * @author Utilisateur
 *
 */
public class InOrderUpdate extends Order{
	
	private String drink;
	private int nbSuger;
	private int nbStick;
	
	public InOrderUpdate(String drink, int nbSuger, int nbStick) {
		super();
		this.drink = drink;
		this.nbSuger = nbSuger;
		this.nbStick = nbStick;
	}

	public InOrderUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public int getNbSuger() {
		return nbSuger;
	}

	public void setNbSuger(int nbSuger) {
		this.nbSuger = nbSuger;
	}

	public int getNbStick() {
		return nbStick;
	}

	public void setNbStick(int nbStick) {
		this.nbStick = nbStick;
	}
}
