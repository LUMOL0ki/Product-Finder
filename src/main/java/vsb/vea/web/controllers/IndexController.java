package vsb.vea.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import vsb.vea.exceptions.FormatException;
import vsb.vea.models.Product;
import vsb.vea.services.CategoryService;
import vsb.vea.services.ProductService;
import vsb.vea.services.SupplierService;
import vsb.vea.web.mapper.CategoryMapper;
import vsb.vea.web.mapper.ProductMapper;
import vsb.vea.web.mapper.SupplierMapper;
import vsb.vea.web.models.CategoryInput;
import vsb.vea.web.models.ProductInput;
import vsb.vea.web.models.SupplierInput;

@Controller
public class IndexController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/")
	public String index(Model model) {
		try {
			model.addAttribute("test", categoryService.findById(1));
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	@GetMapping("/products")
	public String productList(@RequestParam(value = "filter", required = false) String filter, Model model) {
		try {
			model.addAttribute("products", productService.findByNameOrEAN(filter));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "productList";
	}
	
	@GetMapping("/products/management")
	public String productManagement(Model model) {
		model.addAttribute("products", productService.get());
		model.addAttribute("isOpen", false);
		return "productManagement";
	}
	
	@GetMapping("/product/{id}")
	public String productDetail(@PathVariable long id, Model model) {
		try {
			Product product = productService.findById(id);
			model.addAttribute("product", product);
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "productDetail";
	}
	
	@GetMapping("/product")
	public String productCreate(ProductInput product, Model model) {
		productService.create(ProductMapper.fromProductInput(product));
		return "productCreate";
	}

	@GetMapping("/product/edit/{id}")
	public String productEdit(@PathVariable long id, ProductInput product, Model model) {
		productService.edit(ProductMapper.fromProductInput(id, product));
		return "productEdit";
	}
	
	@GetMapping("/categories/management")
	public String categoryManagement(Model model) {
		model.addAttribute("categories", categoryService.get());
		return "categoryManagement";
	}

	@GetMapping("/category/{id}")
	public String categoryDetail(@PathVariable long id, Model model) {
		try {
			model.addAttribute("category", categoryService.findById(id));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "categoryDetail";
	}
	
	@GetMapping("/category")
	public String categoryCreate(CategoryInput category, Model model) {
		categoryService.create(CategoryMapper.fromCategoryInput(category));
		return "categoryCreate";
	}
	
	@GetMapping("/category/edit/{id}")
	public String categoryEdit(@PathVariable long id, CategoryInput category, Model model) {
		categoryService.edit(CategoryMapper.fromCategoryInput(id, category));
		return "categoryEdit";
	}
	
	@GetMapping("/suppliers/management")
	public String supplierManagement(Model model) {
		model.addAttribute("suppliers", supplierService.get());
		return "supplierManagement";
	}

	@GetMapping("/supplier/{id}")
	public String supplierDetail(@PathVariable long id, Model model) {
		try {
			model.addAttribute("supplier", supplierService.findById(id));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "supplierDetail";
	}
	
	@GetMapping("/supplier")
	public String supplierCreate(SupplierInput supplier, Model model) {
		supplierService.create(SupplierMapper.fromSupplierInput(supplier));
		return "supplierCreate";
	}
	
	@GetMapping("/supplier/edit/{id}")
	public String supplierEdit(@PathVariable long id, SupplierInput supplier, Model model) {
		supplierService.edit(SupplierMapper.fromSupplierInput(id, supplier));
		return "supplierEdit";
	}
}
