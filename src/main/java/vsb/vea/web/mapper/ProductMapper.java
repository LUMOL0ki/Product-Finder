package vsb.vea.web.mapper;

import java.util.ArrayList;
import java.util.List;

import vsb.vea.models.Product;
import vsb.vea.web.models.*;

public class ProductMapper {
	public static Product fromProductBrief(ProductBrief productBrief) {
		Product product = new Product(
				productBrief.id,
				productBrief.name,
				productBrief.ean
				);
		return product;
	}
	
	public static List<Product> fromProductBrief(List<ProductBrief> productBriefs) {
		List<Product> products = new ArrayList<Product>();
		for(ProductBrief productBrief : productBriefs) {
			products.add(fromProductBrief(productBrief));
		}
		return products;
	}
	
	public static Product fromProductDetail(ProductDetail productDetail) {
		Product product = new Product(
				productDetail.id,
				productDetail.name,
				productDetail.description,
				productDetail.ean,
				SupplierMapper.fromSupplierBrief(productDetail.supplier),
				CategoryMapper.fromCategoryBrief(productDetail.category)
				);
		return product;
	}
	
	public static Product fromProductInput(ProductInput productInput) {
		Product product = new Product(
				productInput.name,
				productInput.description,
				productInput.ean,
				productInput.supplierId,
				productInput.categoryId
				);
		return product;
	}

	public static Product fromProductInput(int id, ProductInput productInput) {
		Product product = new Product(
				id,
				productInput.name,
				productInput.description,
				productInput.ean,
				productInput.supplierId,
				productInput.categoryId
				);
		return product;
	}
	
	public static ProductBrief toProductBrief(Product product) {
		ProductBrief productBrief = new ProductBrief();
		productBrief.id = product.getId();
		productBrief.name = product.getName();
		productBrief.ean = product.getEan();
		return productBrief;
	}

	public static List<ProductBrief> toProductBrief(List<Product> products) {
		List<ProductBrief> productBriefs = new ArrayList<ProductBrief>();
		for(Product product : products) {
			productBriefs.add(toProductBrief(product));
		}
		return productBriefs;
	}
	
	public static ProductDetail toProductDetail(Product product) {
		ProductDetail productDetail = new ProductDetail();
		productDetail.id = product.getId();
		productDetail.name = product.getName();
		productDetail.description = product.getDescription();
		productDetail.ean = product.getEan();
		productDetail.supplier = SupplierMapper.toSupplierBrief(product.getSupplier());
		productDetail.category = CategoryMapper.toCategoryBrief(product.getCategory());
		return productDetail;
	}
	
	public static ProductInput toProductInput(Product product) {
		ProductInput productInput = new ProductInput();
		productInput.name = product.getName();
		productInput.description = product.getDescription();
		productInput.ean = product.getEan();
		productInput.supplierId = product.getSupplierId();
		productInput.categoryId = product.getCategoryId();
		return productInput;
	}
}
