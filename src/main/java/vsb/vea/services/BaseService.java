package vsb.vea.services;

import java.util.List;

import org.springframework.stereotype.Service;

import vsb.vea.data.irepositories.IBaseRepository;
import vsb.vea.models.BaseEntity;

@Service
public abstract class BaseService<T extends BaseEntity<Long>, TRepository extends IBaseRepository<T>> {
	
	protected TRepository repository;
	
	public BaseService() {
		
	}
	
	public BaseService(TRepository repository) {
		this.repository = repository;
	}
	
	public List<T> get(){
		return repository.get();
	}
	
	public T create(T entity) {
		return repository.create(entity);
	}
	
	public void edit(T entity) {
		repository.edit(entity);
	}
	
	public void remove(T entity) {
		repository.remove(entity);
	}
}
