package vsb.vea.web.mapper;

import vsb.vea.models.Category;
import vsb.vea.web.models.CategoryBrief;
import vsb.vea.web.models.CategoryDetail;
import vsb.vea.web.models.CategoryInput;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryMapper {

    @Autowired
    private static ModelMapper modelMapper = new ModelMapper();
    
	public static Category fromCategoryBrief(CategoryBrief categoryBrief) {
		
		return modelMapper.map(categoryBrief, Category.class);
	}

	public static Category fromCategoryDetail(CategoryDetail categoryDetail) {
		
		return modelMapper.map(categoryDetail, Category.class);
	}

	public static Category fromCategoryInput(CategoryInput categoryInput) {
		
		return modelMapper.map(categoryInput, Category.class);
	}
	
	public static Category fromCategoryInput(long id, CategoryInput categoryInput) {
		Category tempCategory = modelMapper.map(categoryInput, Category.class);
		tempCategory.setId(id);
		return tempCategory;
	}
	
	public static CategoryBrief toCategoryBrief(Category category) {
		return modelMapper.map(category, CategoryBrief.class);
	}
	
	public static CategoryDetail toCategoryDetail(Category category) {
		return modelMapper.map(category, CategoryDetail.class);
	}
	
	public static CategoryInput toCategoryInput(Category category) {
		return modelMapper.map(category, CategoryInput.class);
	}
}
