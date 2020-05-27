package nutrition;

import java.util.EnumMap;
import java.util.Hashtable;

public class Ingredient {
	String ingredientId;
	private static final double PORTION_GRAM_WEIGHT = 100.00;
	
	Ingredient(String ingredientId) {
		this.ingredientId = ingredientId;
	}

	public double nutrientGramWeight(double ingredientGramWeight, Nutrient nutrient) {
		return nutrientGramWeightPerPortion(nutrient) * portionCount(ingredientGramWeight);
	}
	
	private double nutrientGramWeightPerPortion(Nutrient nutrient) {
		return ingredientNutrition().get(nutrient).get("gramWeightPerPortion")
	}
	
	private ingredientData() {
		try {
			return Ingredient.ingredients().get(ingredientId);
		}
		catch (NullPointerException e) {
			return defaultIngredientData();
		}
	}
	
	private Hashtable<String, EnumMap<Nutrient, Hashtable<String, Object>>> defaultIngredientData() {
		Hashtable<String, Hashtable<Nutrient, Hashtable<String, Object>>> defaultIngredientData = new Hashtable<>();
		// create hash with nutrients as keys with value of { "gramWeightPerPortion": 0 } Nutrient.values()
		// { zinc: { gramWeightPerPortion: 0, dataError: "missing nutrient data" }}
		Hashtable<Nutrient, Hashtable<String, Object>> nutrition = new Hashtable<>();
		defaultIngredientData.put("nutrition", nutrition);
		return defaultIngredientData;
	}
	
	private static Hashtable<String, Hashtable<String, Hashtable<Nutrient, Hashtable<String, Object>>>> ingredients() {
		Hashtable<String, Hashtable<String, Hashtable<Nutrient, Hashtable<String, Object>>>> ingredients = new Hashtable<>();
		Hashtable<Nutrient, Hashtable<String, Object>> nutritionForYogurt = new Hashtable<>();
		
		nutritionForYogurt.put(Nutrient.ZINC, nutrientDetails(0.52));
//		nutritionForYogurt.put(Nutrient.IRON, nutrientDetails(0));
//		nutritionForYogurt.put(Nutrient.CALCIUM, nutrientDetails(100.00));
//		nutritionForYogurt.put(Nutrient.CHOLINE, nutrientDetails(15.1));
//		nutritionForYogurt.put(Nutrient.COPPER, nutrientDetails(17.0));
//		nutritionForYogurt.put(Nutrient.FOLATE, nutrientDetails(5.0));
//		nutritionForYogurt.put(Nutrient.MAGNESIUM, nutrientDetails(11.0));
//		nutritionForYogurt.put(Nutrient.NIACIN, nutrientDetails(0.208));
//		nutritionForYogurt.put(Nutrient.PHOSPHORUS, nutrientDetails(135.0));
//		nutritionForYogurt.put(Nutrient.POTASSIUM, nutrientDetails(141.0));
//		nutritionForYogurt.put(Nutrient.RIBOFLAVIN, nutrientDetails(0.278));
//		nutritionForYogurt.put(Nutrient.SELENIUM, nutrientDetails(9.7));
//		nutritionForYogurt.put(Nutrient.SODIUM, nutrientDetails(0.035));
//		nutritionForYogurt.put(Nutrient.THIAMIN, nutrientDetails(0.023));
//		nutritionForYogurt.put(Nutrient.VITAMIN_A, nutrientDetails(2.0));
//		nutritionForYogurt.put(Nutrient.VITAMIN_B12, nutrientDetails(0.75));
//		nutritionForYogurt.put(Nutrient.VITAMIN_B6, nutrientDetails(0.063));
//		nutritionForYogurt.put(Nutrient.VITAMIN_C, nutrientDetails(0.0));
//		nutritionForYogurt.put(Nutrient.VITAMIN_D, nutrientDetails(0.0));
//		nutritionForYogurt.put(Nutrient.VITAMIN_E, nutrientDetails(0.01));
//		nutritionForYogurt.put(Nutrient.VITAMIN_K, nutrientDetails(0.0));
		
		Hashtable<String, Hashtable<Nutrient, Hashtable<String, Object>>> nutrition = new Hashtable<>();
		nutrition.put("nutrition", nutritionForYogurt);
		
		ingredients.put("1049", nutrition);
		
		return ingredients;
	}
	
    private static Hashtable<String, Object> nutrientDetails(double gramWeight) {
        // amount per 100g is in same unit as enum Nutrient unit TODO: change to grams
        Hashtable<String, Object> details = new Hashtable<>();
        
        details.put("gramWeightPerPortion", gramWeight);
        details.put("errors", null);
        
        return details;
    }
    
    private double portionCount(double gramWeight) {
    	return gramWeight/Ingredient.PORTION_GRAM_WEIGHT;
    }
}
