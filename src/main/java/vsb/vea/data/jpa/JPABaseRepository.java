package vsb.vea.data.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.lang.NonNull;

import vsb.vea.data.irepositories.IBaseRepository;
import vsb.vea.models.BaseEntity;

//import org.springframework.data.jpa.repository.JpaRepository;

public abstract class JPABaseRepository<T extends BaseEntity<Long>> implements IBaseRepository<T>{

	@PersistenceContext
	@NonNull
	protected EntityManager context;
	
	@Override
	public abstract List<T> get();

	@Override
	public abstract T findById(long id);

	@Transactional
	@Override
	public T create(T entity) {
		if(!this.exists(entity)) {
			context.persist(entity);
			context.flush();
			return entity;	
		}else {
			return null;
		}
	}

	@Transactional
	@Override
	public void edit(T entity) {
		if(this.exists(entity)) {
			context.merge(entity);	
		}
	}

	@Transactional
	@Override
	public void remove(T entity) {
		if(this.exists(entity)) {
			context.remove(entity);	
		}
	}

	@Override
	public abstract long count();

	@Override
	public abstract boolean exists(T entity);

}
