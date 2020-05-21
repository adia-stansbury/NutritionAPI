package nutrition;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// Calculates nutrition of ingredients
public class NutritionCalculator {
	Hashtable<String, Hashtable<String, Double>> ingredients;
	
	NutritionCalculator(Hashtable<String, Hashtable<String, Double>> ingredients) {
		this.ingredients = ingredients;
	}
	
	public EnumMap<Nutrient, Hashtable<String, Double>> calculate() {
		EnumMap<Nutrient, Hashtable<String, Double>> nutrition = new EnumMap<Nutrient, Hashtable<String, Double>>(Nutrient.class);
		Hashtable<String, Double> nutritionForZinc = new Hashtable<String, Double>();
		nutritionForZinc.put("gramWeight", gramWeight(Nutrient.ZINC));
		nutrition.put(Nutrient.ZINC, nutritionForZinc);
		
		return nutrition;
	}

	private double gramWeight(Nutrient nutrient) {
		return ingredients
				.entrySet()
				.stream()
				.mapToDouble(ingredientMapEntry ->
					nutrientGramWeightInIngredient(ingredientMapEntry.getKey(), ingredientMapEntry.getValue().get("gramWeight"), nutrient)
				)
				.sum();
	}
	
	private double nutrientGramWeightInIngredient(String ingredientID, double ingredientGramWeight, Nutrient nutrient) {
		Ingredient ingredient = new Ingredient(ingredientID);
		return ingredient.nutrientGramWeight(ingredientGramWeight, nutrient);	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
