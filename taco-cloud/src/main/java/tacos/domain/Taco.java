package tacos.domain;

import java.util.List;

public class Taco {
	private String name;
	private List<Ingredient> ingredents;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ingredient> getIngredents() {
		return ingredents;
	}
	public void setIngredents(List<Ingredient> ingredents) {
		this.ingredents = ingredents;
	}
	
	
}
