package vsb.vea.web.controllers;

import java.util.List;

import vsb.vea.exceptions.FormatException;
import vsb.vea.services.ProductService;
import vsb.vea.web.mapper.ProductMapper;
import vsb.vea.web.models.*;

public class ProductController {
	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	public List<ProductBrief> get(){
		return ProductMapper.toProductBrief(service.get());
	}
	
	public ProductDetail findById(int id) {
		try {
			return ProductMapper.toProductDetail(service.findById(id));
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ProductBrief> findByName(String name){
		try {
			return ProductMapper.toProductBrief(service.findByName(name));
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ProductDetail findByEAN(String ean) {
		try {
			return ProductMapper.toProductDetail(service.findByEAN(ean));
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ProductBrief> findByNameOrEAN(String filter){
		try {
			return ProductMapper.toProductBrief(service.findByNameOrEAN(filter));
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void create(ProductInput product) {
		service.create(ProductMapper.fromProductInput(product));
	}
	
	public void edit(int id, ProductInput product) {
		service.edit(ProductMapper.fromProductInput(id, product));
	}
	
	public void remove(int id) {
		try {
			service.remove(id);
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setProductAsReviewing(int id) {
		try {
			service.setProductAsReviewing(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setProductAsApproved(int id) {
		try {
			service.setProductAsApproved(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setProductAsRejected(int id) {
		try {
			service.setProductAsRejected(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
