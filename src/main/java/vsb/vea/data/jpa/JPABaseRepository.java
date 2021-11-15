package vsb.vea.data.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import vsb.vea.data.irepositories.IBaseRepository;
import vsb.vea.models.BaseEntity;

//import org.springframework.data.jpa.repository.JpaRepository;

public abstract class JPABaseRepository<T extends BaseEntity<Long>> /*extends JPARepository<T, Long>*/ implements IBaseRepository<T>{

	@PersistenceContext
	private EntityManager context;
	
	@Override
	public abstract List<T> get();

	@Override
	public abstract T findById(long id);

	@Override
	public T create(T entity) {
		// TODO Auto-generated method stub
		context.persist(entity);
		context.flush();
		return entity;
	}

	@Override
	public void edit(T entity) {
		context.merge(entity);
	}

	@Override
	public void remove(T entity) {
		context.remove(entity);
	}

	@Override
	public abstract long count();

	@Override
	public abstract boolean exists(T entity);

}
