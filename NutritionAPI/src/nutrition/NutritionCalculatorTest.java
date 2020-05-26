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
		
		assertEquals(Nutrient.values().length, nutritionCalculator.calculate().size());
		
		assertEquals(0.26, nutritionCalculator.calculate().get(Nutrient.ZINC).get("gramWeight"));
	}
}
