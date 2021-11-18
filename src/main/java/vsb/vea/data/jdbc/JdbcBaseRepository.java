package vsb.vea.data.jdbc;

import java.util.List;

import vsb.vea.data.irepositories.IBaseRepository;
import vsb.vea.models.BaseEntity;

public abstract class JdbcBaseRepository<T extends BaseEntity<Long>>  implements IBaseRepository<T> {

	@Override
	public abstract List<T> get();
	@Override
	public abstract T findById(long id);
	@Override
	public abstract T create(T entity);
	@Override
	public abstract void edit(T entity);
	@Override
	public abstract void remove(T entity);
	@Override
	public abstract long count();
	@Override
	public abstract boolean exists(T entity);

}
