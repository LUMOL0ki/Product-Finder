package vsb.vea.web.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import vsb.vea.exceptions.FormatException;
import vsb.vea.models.Product;
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

	@GetMapping("/findByName/{name}")
	public List<ProductBrief> findByName(@PathVariable String name){
		try {
			return service.findByName(name).stream().map(ProductMapper::toProductBrief).collect(Collectors.toList());
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/findByEAN/{name}")
	public ResponseEntity<ProductDetail> findByEAN(@PathVariable String ean) {
		try {
			Product product = service.findByEAN(ean);
			return product != null ? ResponseEntity.ok(ProductMapper.toProductDetail(product)) : new ResponseEntity<ProductDetail>(HttpStatus.NOT_FOUND);
		} catch (FormatException e) {
			e.printStackTrace();
			return new ResponseEntity<ProductDetail>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByNameOrEAN/{name}")
	public ResponseEntity<List<ProductBrief>> findByNameOrEAN(@PathVariable String filter){
		try {
			return ResponseEntity.ok(service.findByNameOrEAN(filter).stream().map(ProductMapper::toProductBrief).collect(Collectors.toList()));
		} catch (FormatException e) {
			e.printStackTrace();
			return new ResponseEntity<List<ProductBrief>>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
	public ResponseEntity<ProductDetail> create(ProductInput product) {
		if(product != null) {
			return ResponseEntity.ok(ProductMapper.toProductDetail(service.create(ProductMapper.fromProductInput(product))));
		}
		else {
			return new ResponseEntity<ProductDetail>(HttpStatus.BAD_REQUEST);
		}
		
	}

	@PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> edit(@PathVariable long id, ProductInput product) {
		if(product != null) {
			service.edit(ProductMapper.fromProductInput(id, product));	
			return ResponseEntity.ok("Successfully edited");		
		}
		else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> remove(@PathVariable long id) {
		try {
			service.remove(id);
			return ResponseEntity.ok("Successfully removed");
		} catch (FormatException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	public void setProductAsReviewing(long id) {
		try {
			service.setProductAsReviewing(id);
		} catch (Exception e) {
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
