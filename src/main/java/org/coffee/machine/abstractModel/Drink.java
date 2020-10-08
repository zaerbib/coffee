package org.coffee.machine.abstractModel;

public abstract class Drink {
	private String kindOfDrink;
	
	public Drink(String kindOfDrink) {
		this.kindOfDrink = kindOfDrink;
	}

	public String getKindOfDrink() {
		return kindOfDrink;
	}

	public void setKindOfDrink(String kindOfDrink) {
		this.kindOfDrink = kindOfDrink;
	}
}
