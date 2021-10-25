package vsb.vea.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"vsb.vea.converters", "vsb.vea.data.mock", "vsb.vea.services", "vsb.vea.controllers", "vsb.vea.models"})
public class ProductFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductFinderApplication.class, args);
	}

}
