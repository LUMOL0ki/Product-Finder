package vsb.vea.web.mapper;

import vsb.vea.models.Category;
import vsb.vea.web.models.CategoryBrief;
import vsb.vea.web.models.CategoryDetail;
import vsb.vea.web.models.CategoryInput;
import java.util.List;
import java.util.ArrayList;

public class CategoryMapper {
	
	public static Category fromCategoryBrief(CategoryBrief categoryBrief) {
		Category category = new Category();
		category.id = categoryBrief.id;
		category.name = categoryBrief.name;
		return category;
	}

	public static Category fromCategoryDetail(CategoryDetail categoryDetail) {
		Category category = new Category();
		category.id = categoryDetail.id;
		category.name = categoryDetail.name;
		category.description = categoryDetail.description;
		//category.products = categoryDetail.products;
		return category;
	}

	public static Category fromCategoryInput(CategoryInput categoryInput) {
		Category category = new Category();
		category.name = categoryInput.name;
		category.description = categoryInput.description;
		return category;
	}
	
	public static CategoryBrief toCategoryBrief(Category category) {
		CategoryBrief categoryBrief = new CategoryBrief();
		categoryBrief.id = category.id;
		categoryBrief.name = category.name;
		return categoryBrief;
	}
	
	public static List<CategoryBrief> toCategoryBriefs(List<Category> categories){
		List<CategoryBrief> categoryBriefs = new ArrayList<CategoryBrief>();
		for(Category category : categories) {
			categoryBriefs.add(CategoryMapper.toCategoryBrief(category));
		}
		return categoryBriefs;
	}
	
	public static CategoryDetail toCategoryDetail(Category category) {
		CategoryDetail categoryDetail = new CategoryDetail();
		categoryDetail.id = category.id;
		categoryDetail.name = category.name;
		categoryDetail.description = category.description;
		//categoryDetail.products = category.products;
		return categoryDetail;
	}
	
	public static CategoryInput toCategoryInput(Category category) {
		CategoryInput categoryInput = new CategoryInput();
		categoryInput.name = category.name;
		categoryInput.description = category.description;
		return categoryInput;
	}
}
