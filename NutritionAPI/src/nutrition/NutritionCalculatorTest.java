package nutrition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;

import org.junit.jupiter.api.Test;

class NutritionCalculatorTest {
	
	@Test
	void testCalculate_noErrors() {
		Hashtable<String, Hashtable<String, Double>> ingredientsIntake = new Hashtable<String, Hashtable<String, Double>>();
		
		Hashtable<String, Double> ingredientIntake = new Hashtable<String, Double>();
		ingredientIntake.put("gramWeight", 50.00);
		ingredientsIntake.put("1049", ingredientIntake);
		
		NutritionCalculator nutritionCalculator = new NutritionCalculator(ingredientsIntake);
		
		assertEquals(Nutrient.values().length, nutritionCalculator.calculate().size());
		
		// TODO: remove hardcoded expected value
		assertEquals(0.26, nutritionCalculator.calculate().get(Nutrient.ZINC).get("gramWeight"));
	}
	
	@Test
	void testCalculate_missingIngredientError() {
		Hashtable<String, Hashtable<String, Double>> ingredientsIntake = new Hashtable<String, Hashtable<String, Double>>();
		
		Hashtable<String, Double> ingredientIntake = new Hashtable<String, Double>();
		ingredientIntake.put("gramWeight", 50.00);
		
		String ingredient1ID = "1";
		String ingredient2ID = "2";
		ingredientsIntake.put(ingredient1ID, ingredientIntake);
		ingredientsIntake.put(ingredient2ID, ingredientIntake);
		
		NutritionCalculator nutritionCalculator = new NutritionCalculator(ingredientsIntake);
		
		ArrayList<String> expectedErrors = new ArrayList<>();
		expectedErrors.add("Missing ingredients with ids: " + ingredient1ID + ", " + ingredient2ID);
		
		assertEquals(expectedErrors, nutritionCalculator.calculate().get("errors"));;
	}
}
