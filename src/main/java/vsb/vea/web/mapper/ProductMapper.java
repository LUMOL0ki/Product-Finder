package vsb.vea.web.mapper;

import java.util.ArrayList;
import java.util.List;

import vsb.vea.models.Product;
import vsb.vea.web.models.*;

public class ProductMapper {
	public static Product fromProductBrief(ProductBrief productBrief) {
		Product product = new Product();
		product.id = productBrief.id;
		product.name = productBrief.name;
		product.ean = productBrief.ean;
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
		Product product = new Product();
		product.id = productDetail.id;
		product.name = productDetail.name;
		product.description = productDetail.description;
		product.ean = productDetail.ean;
		product.supplier = SupplierMapper.fromSupplierBrief(productDetail.supplier);
		product.category = CategoryMapper.fromCategoryBrief(productDetail.category);
		return product;
	}
	
	public static Product fromProductInput(ProductInput productInput) {
		Product product = new Product();
		product.name = productInput.name;
		product.description = productInput.description;
		product.ean = productInput.ean;
		product.supplierId = productInput.supplierId;
		product.categoryId = productInput.categoryId;
		return product;
	}

	public static Product fromProductInput(int id, ProductInput productInput) {
		Product product = new Product();
		product.id = id;
		product.name = productInput.name;
		product.description = productInput.description;
		product.ean = productInput.ean;
		product.supplierId = productInput.supplierId;
		product.categoryId = productInput.categoryId;
		return product;
	}
	
	public static ProductBrief toProductBrief(Product product) {
		ProductBrief productBrief = new ProductBrief();
		productBrief.id = product.id;
		productBrief.name = product.name;
		productBrief.ean = product.ean;
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
		productDetail.id = product.id;
		productDetail.name = product.name;
		productDetail.description = product.description;
		productDetail.ean = product.ean;
		productDetail.supplier = SupplierMapper.toSupplierBrief(product.supplier);
		productDetail.category = CategoryMapper.toCategoryBrief(product.category);
		return productDetail;
	}
	
	public static ProductInput toProductInput(Product product) {
		ProductInput productInput = new ProductInput();
		productInput.name = product.name;
		productInput.description = product.description;
		productInput.ean = product.ean;
		productInput.supplierId = product.supplierId;
		productInput.categoryId = product.categoryId;
		return productInput;
	}
}
