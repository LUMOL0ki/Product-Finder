package vsb.vea.data.irepositories;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IBaseRepository<T> {
	List<T> get();
	void create(T entity);
	void edit(T entity);
	void remove(T entity);
	int Count();
}
