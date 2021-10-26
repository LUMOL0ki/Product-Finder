package vsb.vea.data.irepositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import vsb.vea.models.Category;

@Repository
public interface ICategoryRepository extends IBaseRepository<Category> {
	List<Category> findByName(String name);
}
