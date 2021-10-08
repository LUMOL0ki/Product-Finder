package vsb.vea.web.mapper;

import vsb.vea.models.Category;
import vsb.vea.web.models.CategoryBrief;
import vsb.vea.web.models.CategoryDetail;
import vsb.vea.web.models.CategoryInput;
import java.util.List;
import java.util.ArrayList;

public class CategoryMapper {
	
	public static Category fromCategoryBrief(CategoryBrief categoryBrief) {
		return new Category
				(
					categoryBrief.id, 
					categoryBrief.name
				);
	}

	public static Category fromCategoryDetail(CategoryDetail categoryDetail) {
		return new Category
				(
					categoryDetail.id,
					categoryDetail.name,
					categoryDetail.description,
					ProductMapper.fromProductBrief(categoryDetail.products)
				);
	}

	public static Category fromCategoryInput(CategoryInput categoryInput) {
		return new Category
				(
					categoryInput.name, 
					categoryInput.description
				);
	}
	
	public static Category fromCategoryInput(int id, CategoryInput categoryInput) {
		return new Category
				(
					id, 
					categoryInput.name, 
					categoryInput.description
				);
	}
	
	public static CategoryBrief toCategoryBrief(Category category) {
		CategoryBrief categoryBrief = new CategoryBrief();
		categoryBrief.id = category.getId();
		categoryBrief.name = category.getName();
		return categoryBrief;
	}
	
	public static List<CategoryBrief> toCategoryBrief(List<Category> categories){
		List<CategoryBrief> categoryBriefs = new ArrayList<CategoryBrief>();
		for(Category category : categories) {
			categoryBriefs.add(toCategoryBrief(category));
		}
		return categoryBriefs;
	}
	
	public static CategoryDetail toCategoryDetail(Category category) {
		CategoryDetail categoryDetail = new CategoryDetail();
		categoryDetail.id = category.getId();
		categoryDetail.name = category.getName();
		categoryDetail.description = category.getDescription();
		categoryDetail.products = ProductMapper.toProductBrief(category.getProducts());
		return categoryDetail;
	}
	
	public static CategoryInput toCategoryInput(Category category) {
		CategoryInput categoryInput = new CategoryInput();
		categoryInput.name = category.getName();
		categoryInput.description = category.getDescription();
		return categoryInput;
	}
}
