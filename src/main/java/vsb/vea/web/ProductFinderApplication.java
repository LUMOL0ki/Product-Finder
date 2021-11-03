package vsb.vea.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("vsb.vea")
public class ProductFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductFinderApplication.class, args);
	}

}
