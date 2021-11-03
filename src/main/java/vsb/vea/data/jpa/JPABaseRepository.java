package vsb.vea.data.jpa;

import java.util.List;

import vsb.vea.data.irepositories.IBaseRepository;
import vsb.vea.models.BaseEntity;

//import org.springframework.data.jpa.repository.JpaRepository;

public class JPABaseRepository<T extends BaseEntity<Long>> /*extends JPARepository<T, Long>*/ implements IBaseRepository<T>{

	@Override
	public List<T> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T create(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(T entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
