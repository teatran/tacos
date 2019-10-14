package tacos;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import tacos.data.IngredientRepository;
import tacos.domain.Ingredient;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IngredientRestController.class)
@AutoConfigureMockMvc(secure=false)
public class IngredientRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IngredientRepository ingredientRepo;
	
	@Test
	public void findAll() throws Exception {
		// given
		Ingredient ing = new Ingredient("123", "botnhao", Ingredient.Type.PROTEIN);
		List<Ingredient> allTestIngredients = Arrays.asList(ing);
		given(ingredientRepo.findAll()).willReturn(allTestIngredients);
		
		// when + then
		this.mockMvc.perform(get("/ingredient/all"))
			.andExpect(status().isOk())
			.andExpect(content().json("[{'id': '123', 'name': 'botnhao', 'type': 'PROTEIN'}]"));
	}
	
}
