package nutrition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;

import org.junit.jupiter.api.Test;

class NutritionCalculatorTest {
	
	@Test
	void testCalculate() {
		Hashtable<String, Hashtable<String, Double>> ingredientsIntake = new Hashtable<String, Hashtable<String, Double>>();
		
		Hashtable<String, Double> ingredientIntake = new Hashtable<String, Double>();
		ingredientIntake.put("gramWeight", 50.00);
		ingredientsIntake.put("1049", ingredientIntake);
		
		NutritionCalculator nutritionCalculator = new NutritionCalculator(ingredientsIntake);
		
		EnumMap<Nutrient, Hashtable<String, Double>> expectedNutrition = new EnumMap<Nutrient, Hashtable<String, Double>>(Nutrient.class);
		Hashtable<String, Double> nutritionForZinc = new Hashtable<String, Double>();
		nutritionForZinc.put("gramWeight", 0.26);
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
