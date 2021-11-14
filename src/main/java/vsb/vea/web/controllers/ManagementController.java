package vsb.vea.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/management")
public class ManagementController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/products")
	public String productManagementPage(Model model) {
		model.addAttribute("products", productService.get());
		return "productManagement";
	}

	@GetMapping("/product/{id}")
	public String productManagementDetailPage(@PathVariable long id, Model model) {
		try {
			Product product = productService.findById(id);
			model.addAttribute("product", product);
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "productManagementDetail";
	}

	@GetMapping("/product")
	public String productCreatePage(Model model) {
		return "productCreate";
	}
	
	@GetMapping("/product/edit/{id}")
	public String productEditPage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		return "productEdit";
	}

	@GetMapping("/product/remove/{id}")
	public String productRemovePage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		return "productRemove";
	}
	
	@GetMapping("/product/create")
	public String productCreate(ProductInput product, Model model) {
		productService.create(ProductMapper.fromProductInput(product));
		return "productManagement";
	}
	
	@GetMapping("/product/edit")
	public String productEdit(long id, ProductInput product, Model model) {
		productService.edit(ProductMapper.fromProductInput(id, product));
		return "productManagement";
	}

	@GetMapping("/product/remove")
	public String productRemove(long id, Model model) {
		return "productManagement";
	}
	
	@GetMapping("/categories")
	public String categoryManagementPage(Model model) {
		model.addAttribute("categories", categoryService.get());
		return "categoryManagement";
	}

	@GetMapping("/category/{id}")
	public String categoryManagementDetailPage(@PathVariable long id, Model model) {
		try {
			model.addAttribute("category", categoryService.findById(id));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "categoryManagementDetail";
	}
	
	@GetMapping("/category")
	public String categoryCreatePage(Model model) {
		return "categoryCreate";
	}
	
	@GetMapping("/category/edit/{id}")
	public String categoryEditPage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		return "categoryEdit";
	}

	@GetMapping("/category/remove/{id}")
	public String categoryRemovePage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		return "categoryRemove";
	}
	
	@GetMapping("/category/create")
	public String categoryCreate(CategoryInput category, Model model) {
		categoryService.create(CategoryMapper.fromCategoryInput(category));
		return "categoryManagement";
	}
	
	@GetMapping("/category/edit")
	public String categoryEdit(long id, CategoryInput category, Model model) {
		categoryService.edit(CategoryMapper.fromCategoryInput(id, category));
		return "categoryManagement";
	}

	@GetMapping("/category/remove")
	public String categoryRemove(@RequestParam(value = "id", required = false) long id, Model model) {
		try {
			categoryService.remove(id);
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "categoryManagement";
	}
	
	@GetMapping("/suppliers")
	public String supplierManagementPage(Model model) {
		model.addAttribute("suppliers", supplierService.get());
		return "supplierManagement";
	}

	@GetMapping("/supplier/{id}")
	public String supplierManagementDetailPage(@PathVariable long id, Model model) {
		try {
			model.addAttribute("supplier", supplierService.findById(id));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "supplierManagementDetail";
	}

	@GetMapping("/supplier")
	public String supplierCreatePage(Model model) {
		return "supplierCreate";
	}
	
	@GetMapping("/supplier/edit/{id}")
	public String supplierEditPage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		return "supplierEdit";
	}

	@GetMapping("/supplier/remove/{id}")
	public String supplierRemovePage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		return "supplierRemove";
	}
	
	@GetMapping("/supplier/create")
	public String supplierCreate(SupplierInput supplier, Model model) {
		supplierService.create(SupplierMapper.fromSupplierInput(supplier));
		return "supplierManagement";
	}
	
	@GetMapping("/supplier/edit")
	public String supplierEdit(long id, SupplierInput supplier, Model model) {
		supplierService.edit(SupplierMapper.fromSupplierInput(id, supplier));
		return "supplierManagement";
	}
	
	@GetMapping("/supplier/remove")
	public String supplierRemove(long id, Model model) {
		try {
			supplierService.remove(id);
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "supplierManagement";
	}
}
