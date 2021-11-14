package vsb.vea.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import vsb.vea.exceptions.FormatException;
import vsb.vea.models.Product;
import vsb.vea.services.ProductService;

@Controller
public class IndexController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String index(Model model) {
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
}
