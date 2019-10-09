package tacos.data;

import java.util.List;

import tacos.domain.Ingredient;

public interface IngredientRepository {
	
	List<Ingredient> findAll();
	
	Ingredient findOne(String id);
	
	Ingredient save(Ingredient ingredient);
}
