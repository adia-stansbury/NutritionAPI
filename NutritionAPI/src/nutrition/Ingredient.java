package nutrition;

import java.util.Hashtable;

public class Ingredient {
	String ingredientId;
	
	Ingredient(String ingredientId) {
		this.ingredientId = ingredientId;
	}

	public double nutrientGramWeight(double ingredientGramWeight, Nutrient nutrient) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static Hashtable<String, Hashtable<String, Double>> ingredients() {
		nutritionForYogurt.put(Nutrient.ZINC, nutrientDetails(0.52));
		nutritionForYogurt.put(Nutrient.IRON, nutrientDetails(0));
		nutritionForYogurt.put(Nutrient.CALCIUM, nutrientDetails(100.00));
		nutritionForYogurt.put(Nutrient.CHOLINE, nutrientDetails(15.1));
		nutritionForYogurt.put(Nutrient.COPPER, nutrientDetails(17.0));
		nutritionForYogurt.put(Nutrient.FOLATE, nutrientDetails(5.0));
		nutritionForYogurt.put(Nutrient.MAGNESIUM, nutrientDetails(11.0));
		nutritionForYogurt.put(Nutrient.NIACIN, nutrientDetails(0.208));
		nutritionForYogurt.put(Nutrient.PHOSPHORUS, nutrientDetails(135.0));
		nutritionForYogurt.put(Nutrient.POTASSIUM, nutrientDetails(141.0));
		nutritionForYogurt.put(Nutrient.RIBOFLAVIN, nutrientDetails(0.278));
		nutritionForYogurt.put(Nutrient.SELENIUM, nutrientDetails(9.7));
		nutritionForYogurt.put(Nutrient.SODIUM, nutrientDetails(0.035));
		nutritionForYogurt.put(Nutrient.THIAMIN, nutrientDetails(0.023));
		nutritionForYogurt.put(Nutrient.VITAMIN_A, nutrientDetails(2.0));
		nutritionForYogurt.put(Nutrient.VITAMIN_B12, nutrientDetails(0.75));
		nutritionForYogurt.put(Nutrient.VITAMIN_B6, nutrientDetails(0.063));
		nutritionForYogurt.put(Nutrient.VITAMIN_C, nutrientDetails(0.0));
		nutritionForYogurt.put(Nutrient.VITAMIN_D, nutrientDetails(0.0));
		nutritionForYogurt.put(Nutrient.VITAMIN_E, nutrientDetails(0.01));
		nutritionForYogurt.put(Nutrient.VITAMIN_K, nutrientDetails(0.0));
	}
}
