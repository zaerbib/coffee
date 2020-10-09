package org.coffee.machine.abstractModel;

public abstract class Order {
	private char drink;
	private int nbSugar, nbStick;
	private String drinkUpdate;
	
	public Order(char drink, int nbSugar, int nbStick) {
		this.drink = drink;
		this.nbSugar = nbSugar;
		this.nbStick = nbStick;
	}
	
	public Order(String drinkUpdate, int nbSugar, int nbStick) {
		this.drinkUpdate = drinkUpdate;
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

	public String getDrinkUpdate() {
		return drinkUpdate;
	}

	public void setDrinkUpdate(String drinkUpdate) {
		this.drinkUpdate = drinkUpdate;
	}
}
