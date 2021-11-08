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
	public String productListPage(@RequestParam(value = "filter", required = false) String filter, Model model) {
		try {
			model.addAttribute("products", productService.findByNameOrEAN(filter));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "productList";
	}

	@GetMapping("/product/{id}")
	public String productDetailPage(@PathVariable long id, Model model) {
		try {
			Product product = productService.findById(id);
			model.addAttribute("product", product);
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "productDetail";
	}
	
	@GetMapping("/management/products")
	public String productManagementPage(Model model) {
		model.addAttribute("products", productService.get());
		return "productManagement";
	}

	@GetMapping("/management/product/{id}")
	public String productManagementDetailPage(@PathVariable long id, Model model) {
		try {
			Product product = productService.findById(id);
			model.addAttribute("product", product);
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "productManagementDetail";
	}

	@GetMapping("/management/product")
	public String productCreatePage(Model model) {
		return "productCreate";
	}
	
	@GetMapping("/management/product/edit/{id}")
	public String productEditPage(@PathVariable long id, Model model) {
		return "productEdit";
	}

	@GetMapping("/management/product/create")
	public String productCreate(ProductInput product, Model model) {
		productService.create(ProductMapper.fromProductInput(product));
		return "productManagement";
	}
	
	@GetMapping("/management/product/edit")
	public String productEdit(long id, ProductInput product, Model model) {
		productService.edit(ProductMapper.fromProductInput(id, product));
		return "productManagement";
	}

	@GetMapping("/management/product/remove")
	public String productRemove(long id, Model model) {
		return "productManagement";
	}
	
	@GetMapping("/management/categories")
	public String categoryManagementPage(Model model) {
		model.addAttribute("categories", categoryService.get());
		return "categoryManagement";
	}

	@GetMapping("/management/category/{id}")
	public String categoryManagementDetailPage(@PathVariable long id, Model model) {
		try {
			model.addAttribute("category", categoryService.findById(id));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "categoryManagementDetail";
	}
	
	@GetMapping("/management/category")
	public String categoryCreatePage(Model model) {
		return "categoryCreate";
	}
	
	@GetMapping("/management/category/edit/{id}")
	public String categoryEditPage(@PathVariable long id, Model model) {
		//categoryService.edit(CategoryMapper.fromCategoryInput(id, category));
		return "categoryEdit";
	}

	@GetMapping("/management/category/create")
	public String categoryCreate(CategoryInput category, Model model) {
		categoryService.create(CategoryMapper.fromCategoryInput(category));
		return "categoryManagement";
	}
	
	@GetMapping("/management/category/edit")
	public String categoryEdit(long id, CategoryInput category, Model model) {
		categoryService.edit(CategoryMapper.fromCategoryInput(id, category));
		return "categoryManagement";
	}

	@GetMapping("/management/category/remove")
	public String categoryRemove(long id, Model model) {
		try {
			categoryService.remove(id);
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "categoryManagement";
	}
	
	@GetMapping("/management/suppliers")
	public String supplierManagementPage(Model model) {
		model.addAttribute("suppliers", supplierService.get());
		return "supplierManagement";
	}

	@GetMapping("/management/supplier/{id}")
	public String supplierManagementDetailPage(@PathVariable long id, Model model) {
		try {
			model.addAttribute("supplier", supplierService.findById(id));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "supplierManagementDetail";
	}

	@GetMapping("/management/supplier")
	public String supplierCreatePage(Model model) {
		return "supplierCreate";
	}
	
	@GetMapping("/management/supplier/edit/{id}")
	public String supplierEditPage(@PathVariable long id, Model model) {
		return "supplierEdit";
	}

	@GetMapping("/management/supplier/create")
	public String supplierCreate(SupplierInput supplier, Model model) {
		supplierService.create(SupplierMapper.fromSupplierInput(supplier));
		return "supplierManagement";
	}
	
	@GetMapping("/management/supplier/edit")
	public String supplierEdit(long id, SupplierInput supplier, Model model) {
		supplierService.edit(SupplierMapper.fromSupplierInput(id, supplier));
		return "supplierManagement";
	}
	
	@GetMapping("/management/supplier/remove")
	public String supplierRemove(long id, Model model) {
		try {
			supplierService.remove(id);
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "supplierManagement";
	}
}
