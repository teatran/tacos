package tacos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tacos.domain.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcIngredientRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public List<Ingredient> findAll() {
	
		return jdbc.query("select id, name, type from Ingredient", 
				this::mapRowToIngredient);
	}
	
	private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
		
		return new Ingredient(
				rs.getString("id"), 
				rs.getString("name"), 
				Ingredient.Type.valueOf(rs.getString("type")));
	}
	
	@Override
	public Ingredient findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
