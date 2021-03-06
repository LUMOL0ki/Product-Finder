package vsb.vea.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import vsb.vea.exceptions.FormatException;
import vsb.vea.models.Product;
import vsb.vea.models.Supplier;
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
	public String productCreatePage(@ModelAttribute("product") ProductInput product, Model model) {
		model.addAttribute("categories", categoryService.get());
		model.addAttribute("suppliers", supplierService.get());
		model.addAttribute("product", product);
		return "productCreate";
	}
	
	@GetMapping("/product/edit/{id}")
	public String productEditPage(@PathVariable long id, Model model) {
		try {
			model.addAttribute("categories", categoryService.get());
			model.addAttribute("suppliers", supplierService.get());
			model.addAttribute("product", productService.findById(id));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		model.addAttribute("id", id);
		model.addAttribute("categories", categoryService.get());
		model.addAttribute("suppliers", supplierService.get());
		return "productEdit";
	}

	@GetMapping("/product/remove/{id}")
	@Secured("ROLE_REVIEWER")
	public String productRemovePage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		return "productRemove";
	}
	
	@PostMapping("/product/create")
	public String productCreate(@ModelAttribute("product") @Validated ProductInput product, BindingResult error, Model model) {
		if(error.hasErrors()) {
			model.addAttribute("categories", categoryService.get());
			model.addAttribute("suppliers", supplierService.get());
			model.addAttribute("product", product);
			return "productCreate";
		}
		
		productService.create(ProductMapper.fromProductInput(product));
		return "redirect:/management/products";
	}
	
	@PostMapping("/product/edit/{id}")
	public String productEdit(@PathVariable long id, @ModelAttribute("product") @Validated ProductInput product, BindingResult error, Model model) {
		if(error.hasErrors()) {
			model.addAttribute("id", id);
			model.addAttribute("product", product);
			return "productEdit";
		}
		
		productService.edit(ProductMapper.fromProductInput(id, product));
		return "redirect:/management/products";
	}

	@PostMapping("/product/remove")
	@Secured("ROLE_REVIEWER")
	public RedirectView productRemove(long id, Model model) {
		try {
			productService.remove(id);
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RedirectView("/management/products");
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
	@Secured("ROLE_REVIEWER")
	public String categoryCreatePage(@ModelAttribute("category") CategoryInput category, Model model) {
		return "categoryCreate";
	}
	
	@GetMapping("/category/edit/{id}")
	@Secured("ROLE_REVIEWER")
	public String categoryEditPage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		try {
			model.addAttribute("category", categoryService.findById(id));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "categoryEdit";
	}

	@GetMapping("/category/remove/{id}")
	@Secured("ROLE_REVIEWER")
	public String categoryRemovePage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		return "categoryRemove";
	}
	
	@PostMapping("/category/create")
	@Secured("ROLE_REVIEWER")
	public String categoryCreate(@ModelAttribute("category") @Validated CategoryInput category, BindingResult error, Model model) {
		if(error.hasErrors()) {
			model.addAttribute("category", category);
			return "categoryCreate";
		}
		
		categoryService.create(CategoryMapper.fromCategoryInput(category));
		return "redirect:/management/categories";
	}
	
	@PostMapping("/category/edit/{id}")
	@Secured("ROLE_REVIEWER")
	public String categoryEdit(@PathVariable long id, @ModelAttribute("category") @Validated CategoryInput category, BindingResult error, Model model) {
		if(error.hasErrors()) {
			model.addAttribute("id", id);
			model.addAttribute("category", category);
			return "categoryEdit";
		}
		
		categoryService.edit(CategoryMapper.fromCategoryInput(id, category));
		return "redirect:/management/categories";
	}

	@PostMapping("/category/remove")
	@Secured("ROLE_REVIEWER")
	public RedirectView categoryRemove(@RequestParam(value = "id", required = false) long id, Model model) {
		try {
			categoryService.remove(id);
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RedirectView("/management/categories");
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
		model.addAttribute("supplier", new SupplierInput());
		return "supplierCreate";
	}
	
	@GetMapping("/supplier/edit/{id}")
	@Secured("ROLE_REVIEWER")
	public String supplierEditPage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		try {
			model.addAttribute("supplier", supplierService.findById(id));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "supplierEdit";
	}

	@GetMapping("/supplier/remove/{id}")
	@Secured("ROLE_REVIEWER")
	public String supplierRemovePage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		return "supplierRemove";
	}
	
	@PostMapping("/supplier/create")
	public String supplierCreate(@ModelAttribute("supplier") @Validated SupplierInput supplier, BindingResult error, Model model) {
		if(error.hasErrors()) {
			model.addAttribute("supplier", supplier);
			return "supplierCreate";
		}
		
		supplierService.create(SupplierMapper.fromSupplierInput(supplier));
		return "redirect:/management/suppliers";
	}
	
	@PostMapping("/supplier/edit/{id}")
	@Secured("ROLE_REVIEWER")
	public String supplierEdit(@PathVariable long id, @ModelAttribute("supplier") @Validated SupplierInput supplier, BindingResult error, Model model) {
		if(error.hasErrors()) {
			model.addAttribute("id", id);
			model.addAttribute("supplier", supplier);
			return "supplierEdit";
		}
		
		supplierService.edit(SupplierMapper.fromSupplierInput(id, supplier));
		return "redirect:/management/suppliers";
	}
	
	@PostMapping("/supplier/remove")
	@Secured("ROLE_REVIEWER")
	public RedirectView supplierRemove(long id, Model model) {
		try {
			supplierService.remove(id);
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return new RedirectView("/management/suppliers");
	}
}
