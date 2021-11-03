package vsb.vea.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vsb.vea.exceptions.FormatException;
import vsb.vea.services.CategoryService;
import vsb.vea.services.ProductService;
import vsb.vea.services.SupplierService;

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
	
	@GetMapping("/productList")
	public String productList(@RequestParam(value = "filter", required = false) String filter, Model model) {
		try {
			model.addAttribute("products", productService.findByNameOrEAN(filter));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "productList";
	}
	
	@GetMapping("/productDetail/{id}")
	public String productDetail(@PathVariable long id, Model model) {
		try {
			model.addAttribute("product", productService.findById(id));
		} catch (FormatException e) {
			e.printStackTrace();
		}
		return "productDetail";
	}
}
