package vsb.vea.web.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(productInput, Product.class);
	}

	public static Product fromProductInput(long id, ProductInput productInput) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Product product = modelMapper.map(productInput, Product.class);
		product.setId(id);
		return product;
	}
	
	public static ProductBrief toProductBrief(Product product) {
		return modelMapper.map(product, ProductBrief.class);
	}

	public static ProductDetail toProductDetail(Product product) {
		ProductDetail productDetail = modelMapper.map(product, ProductDetail.class);
		productDetail.setSupplier(modelMapper.map(product.getSupplier(), SupplierBrief.class));
		productDetail.setCategory(modelMapper.map(product.getCategory(), CategoryBrief.class));
		return productDetail;
	}
	
	public static ProductInput toProductInput(Product product) {
		return modelMapper.map(product, ProductInput.class);
	}
}
