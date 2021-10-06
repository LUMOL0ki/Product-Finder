package vsb.vea.data.irepositories;

import java.util.List;

public interface IBaseRepository<T> {
	List<T> get();
	void create(T entity);
	void edit(T entity);
	void remove(T entity);
	int Count();
}
