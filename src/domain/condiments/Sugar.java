package domain.condiments;

import java.util.ArrayList;

import domain.drinks.Drink;

public class Sugar extends CondimentDecorator {

	public Sugar(Drink drink, long qty) {
		this.drink = drink;
		this.name = "Sugar";
		this.qty = qty;
	}
}
