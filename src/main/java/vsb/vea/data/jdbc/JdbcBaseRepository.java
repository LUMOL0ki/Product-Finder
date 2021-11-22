package vsb.vea.data.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import vsb.vea.data.irepositories.IBaseRepository;
import vsb.vea.models.BaseEntity;

public abstract class JdbcBaseRepository<T extends BaseEntity<Long>>  implements IBaseRepository<T> {

	protected JdbcTemplate jdbcTemplate;
	protected SimpleJdbcInsert insert;

	@Override
	public abstract List<T> get();
	@Override
	public abstract T findById(long id);
	
	@Override
	public T create(T entity) {
		if (entity.getId() == 0) {
			insert.execute(new BeanPropertySqlParameterSource(entity));
		} else {
			// update
		}
		return null;
	}

	@Override
	public abstract void edit(T entity);
	@Override
	public abstract void remove(T entity);
	@Override
	public abstract long count();
	@Override
	public abstract boolean exists(T entity);

}
