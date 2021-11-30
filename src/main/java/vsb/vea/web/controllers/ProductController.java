package vsb.vea.web.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vsb.vea.exceptions.FormatException;
import vsb.vea.services.ProductService;
import vsb.vea.web.mapper.ProductMapper;
import vsb.vea.web.models.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping	
    @ResponseBody
	public List<ProductBrief> get(){
		return service.get().stream().map(ProductMapper::toProductBrief).collect(Collectors.toList());
	}

	@GetMapping("/find/{id}")
    @ResponseBody
	public ProductDetail findById(@PathVariable long id) {
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
			return service.findByName(name).stream().map(ProductMapper::toProductBrief).collect(Collectors.toList());
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
			return service.findByNameOrEAN(filter).stream().map(ProductMapper::toProductBrief).collect(Collectors.toList());
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void create(ProductInput product) {
		service.create(ProductMapper.fromProductInput(product));
	}
	
	public void edit(long id, ProductInput product) {
		service.edit(ProductMapper.fromProductInput(id, product));
	}
	
	public void remove(long id) {
		try {
			service.remove(id);
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setProductAsReviewing(long id) {
		try {
			service.setProductAsReviewing(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setProductAsApproved(long id) {
		try {
			service.setProductAsApproved(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setProductAsRejected(long id) {
		try {
			service.setProductAsRejected(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
