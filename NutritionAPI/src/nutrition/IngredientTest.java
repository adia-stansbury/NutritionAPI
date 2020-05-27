package nutrition;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IngredientTest {
	// TODO: stub ingredients and constant

	@Test
	void testNutrientGramWeight_haveIngredientNutrition() {
		Ingredient ingredient = new Ingredient("1049");
		
		assertEquals(0.26, ingredient.nutrientGramWeight(50.00, Nutrient.ZINC));
	}
	
	@Test
	void testNutrientGramWeight_missingIngredientNutrition() {
		String ingredientID = "1";
		Ingredient ingredient = new Ingredient(ingredientID);
		
		assertEquals(0.00, ingredient.nutrientGramWeight(50.00, Nutrient.ZINC));
	}
}
