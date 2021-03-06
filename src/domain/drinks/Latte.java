package domain.drinks;

import java.util.ArrayList;

import domain.RecipeInstruction;

public class Latte extends Drink {
	
	public Latte() {
		ArrayList<RecipeInstruction> instructions = new ArrayList<RecipeInstruction>();
		instructions.add(new RecipeInstruction("steam", "milk"));
		instructions.add(new RecipeInstruction("add", "expresso"));
		instructions.add(new RecipeInstruction("top", "whipped cream"));
		
		this.name = "Latte";
		this.description = "Coffee drink with milk and whipped cream";
		recipe = instructions;
	}

}
