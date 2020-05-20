package nutrition;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Calculates nutrition of ingredients
public class NutritionCalculator {
	// { "1049": { gramWeight: 5 }}
	HashMap<String, HashMap<String, Double>> ingredientsIntake;
	
	NutritionCalculator(HashMap<String, HashMap<String, Double>> ingredientsIntake) {
		this.ingredientsIntake = ingredientsIntake;
	}
	
	public EnumMap<Nutrient, HashMap<String, Double>> calculate() {
		EnumMap<Nutrient, HashMap<String, Double>> nutrition = new EnumMap<Nutrient, HashMap<String, Double>>(Nutrient.class);
		HashMap<String, Double> nutritionForZinc = new HashMap<String, Double>();
		nutritionForZinc.put("gramWeight", gramWeight(Nutrient.ZINC));
		nutrition.put(Nutrient.ZINC, nutritionForZinc);
		
		return nutrition;
	}

	private double gramWeight(Nutrient nutrient) {
		Iterator ingredientIntakeIterator = ingredientIntakeIterator();
		while (ingredientIntakeIterator.hasNext()) {
			Map.Entry ingredientIntake = (Map.Entry)ingredientIntakeIterator.next(); // TODO: fix Map.Entry to include hashMap as value
			nutrition((String) ingredientIntake.getKey(), (double) ingredientIntake.get("gramWeight").nutrient);
			
		}
	}
	
	private double nutrition(String ingredientID, double ingredientGramWeight, Nutrient nutrient) {
		Ingredient ingredient = new Ingredient(ingredientID);
		return ingredient.nutrientGramWeight(ingredientGramWeight, nutrient);	
	}

	private Iterator ingredientIntakeIterator() {
		Iterator ingredientIntakeIterator = ingredientsIntake.entrySet().iterator();
		return ingredientIntakeIterator;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
