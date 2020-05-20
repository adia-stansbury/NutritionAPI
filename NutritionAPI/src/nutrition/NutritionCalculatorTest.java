package nutrition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class NutritionCalculatorTest {
	
	@Test
	void testCalculate() {
		HashMap<String, HashMap<String, Double>> ingredientsIntake = new HashMap<String, HashMap<String, Double>>();
		
		HashMap<String, Double> ingredientIntake = new HashMap<String, Double>();
		ingredientIntake.put("gramWeight", 50.00);
		ingredientsIntake.put("1049", ingredientIntake);
		
		NutritionCalculator nutritionCalculator = new NutritionCalculator(ingredientsIntake);
		
		EnumMap<Nutrient, HashMap<String, Double>> expectedNutrition = new EnumMap<Nutrient, HashMap<String, Double>>(Nutrient.class);
		HashMap<String, Double> nutritionForZinc = new HashMap<String, Double>();
		nutritionForZinc.put("gramWeight", 5.00);
		expectedNutrition.put(Nutrient.ZINC, nutritionForZinc);
		
		assertEquals(Nutrient.values().length, nutritionCalculator.calculate().size());
		
		assertEquals(
				expectedNutrition.get(Nutrient.ZINC).get("gramWeight"), 
				nutritionCalculator.calculate().get(Nutrient.ZINC).get("gramWeight")
		);
		
	}
	
	@Test
	void nutrientGramIntake() {
	}

}
