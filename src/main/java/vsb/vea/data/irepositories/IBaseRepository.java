package vsb.vea.data.irepositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import vsb.vea.models.BaseEntity;

@Repository
public interface IBaseRepository<T extends BaseEntity<Long>> {
	List<T> get();
	T findById(long id);
	T create(T entity);
	void edit(T entity);
	void remove(T entity);
	int count();
}
