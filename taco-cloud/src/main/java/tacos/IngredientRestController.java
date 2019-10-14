package tacos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tacos.data.IngredientRepository;
import tacos.domain.Ingredient;

@RestController
@RequestMapping(path="/ingredient", produces="application/json")
public class IngredientRestController {
	
	private final IngredientRepository ingredientRepo;
	
	@Autowired
	public IngredientRestController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@GetMapping("/all")
	public List<Ingredient> findAll() {
		return ingredientRepo.findAll();
	}
}
