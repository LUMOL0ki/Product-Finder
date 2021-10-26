package vsb.vea.data.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.IBaseRepository;
import vsb.vea.models.BaseEntity;

@Repository
public abstract class MockBaseRepository<T extends BaseEntity> implements IBaseRepository<T>{
	
	protected List<T> entities;
	protected int index = 1;
	
	public MockBaseRepository() {
		entities = new ArrayList<T>();
	}

	protected abstract void initialize();
	
	@Override
	public List<T> get() {
		return entities;
	}	

	@Override
	public T findById(int id) {
		List<T> tempEntities = entities.stream().filter(c -> c.getId() == id).collect(Collectors.toList());
		if(tempEntities.size() > 0) {
			return tempEntities.get(0);
		}
		else {
			return null;
		}
	}
	
	@Override
	public void create(T entity) {
		entity.setId(index);
		entities.add(entity);
		index++;
	}

	@Override
	public void edit(T entity) {
		entities.set(entities.indexOf(findById(entity.getId())), entity);
	}

	@Override
	public void remove(T entity) {
		entities.remove(entity);
		//entities.removeIf(e -> e.getId() == entity.getId());
	}

	@Override
	public int Count() {
		return entities.size();
	}
}
