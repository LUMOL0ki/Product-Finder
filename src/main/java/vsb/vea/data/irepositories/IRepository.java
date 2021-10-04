package vsb.vea.data.irepositories;

public interface IRepository<T> {
	void create(T entity);
	void edit(T entity);
	void remove(T entity);
}
