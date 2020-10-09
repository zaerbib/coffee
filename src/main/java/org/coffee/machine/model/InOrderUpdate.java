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
	
	public InOrderUpdate(String drink, int nbSuger, int nbStick) {
		super(drink, nbSuger, nbStick);
	}

}
