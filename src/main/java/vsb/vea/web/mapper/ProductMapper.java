package vsb.vea.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import vsb.vea.models.Product;
import vsb.vea.web.models.*;

public class ProductMapper {

    @Autowired
    private static ModelMapper modelMapper = new ModelMapper();
    
	public static Product fromProductBrief(ProductBrief productBrief) {
		return modelMapper.map(productBrief, Product.class);
	}
		
	public static Product fromProductDetail(ProductDetail productDetail) {
		return modelMapper.map(productDetail, Product.class);
	}
	
	public static Product fromProductInput(ProductInput productInput) {
		return modelMapper.map(productInput, Product.class);
	}

	public static Product fromProductInput(long id, ProductInput productInput) {
		Product product = modelMapper.map(productInput, Product.class);
		product.setId(id);
		return product;
	}
	
	public static ProductBrief toProductBrief(Product product) {
		return modelMapper.map(product, ProductBrief.class);
	}

	public static ProductDetail toProductDetail(Product product) {
		return modelMapper.map(product, ProductDetail.class);
	}
	
	public static ProductInput toProductInput(Product product) {
		return modelMapper.map(product, ProductInput.class);
	}
}
