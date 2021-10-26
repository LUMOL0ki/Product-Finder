package vsb.vea.services;

import java.util.List;

import org.springframework.stereotype.Service;

import vsb.vea.data.irepositories.IBaseRepository;
import vsb.vea.models.BaseEntity;

@Service
public class BaseService<T extends BaseEntity, TRepository extends IBaseRepository<T>> {
	
	protected TRepository repository;
	
	public BaseService() {
		
	}
	
	public BaseService(TRepository repository) {
		this.repository = repository;
	}
	
	public List<T> get(){
		return repository.get();
	}
	
	public void create(T entity) {
		repository.create(entity);
	}
	
	public void edit(T entity) {
		repository.edit(entity);
	}
	
	public void remove(T entity) {
		repository.remove(entity);
	}
}
