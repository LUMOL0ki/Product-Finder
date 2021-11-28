package vsb.vea.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vsb.vea.models.Category;

public class CategoryRowMapper implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Category(
				rs.getInt("id"), 
				rs.getString("name"), 
				rs.getString("description"));
	}

	
}
