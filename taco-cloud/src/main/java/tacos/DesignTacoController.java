package tacos;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.data.IngredientRepository;
import tacos.domain.Ingredient;
import tacos.domain.Ingredient.Type;
import tacos.domain.Taco;

@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	private static final Logger log = LoggerFactory.getLogger(DesignTacoController.class);
	
	private final IngredientRepository ingredientRepo;
	
	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredents = ingredientRepo.findAll();
		
		Type[] types = Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(),
					filterByType(ingredents, type));
			log.info("Add to model: " + type.toString().toLowerCase());
		}
		
		model.addAttribute("design", new Taco());
		
		return "design";
	}
	
	@PostMapping
	public String processDesignForm(@Valid @ModelAttribute("design") Taco design, Errors errors) {
		if (errors.hasErrors()) {
			return "design";
		}
		
		// save the tace
		log.info("Process design: " + design);
		
		return "redirect:/";
	}
	
	
	private List<Ingredient> filterByType(List<Ingredient> ingredents, Type type) {
		
		return ingredents
				.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}
}
