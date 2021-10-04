package vsb.vea.data.irepositories;

import java.util.List;

import vsb.vea.models.Category;

public interface ICategoryRepository extends IBaseRepository<Category> {
	Category findById(int id);
	List<Category> findByName(String name);
}
