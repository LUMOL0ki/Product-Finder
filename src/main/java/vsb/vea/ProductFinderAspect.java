package vsb.vea;

import java.util.List;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import vsb.vea.models.Product;

@Aspect
@Component
public class ProductFinderAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* vsb.vea.web.controllers.IndexController.productListPage(..))")
	public void beforeGet() {
		logger.info("Someone is looking for something");
	}
	
	@AfterReturning(pointcut = "execution(* vsb.vea.services.ProductService.findByNameOrEAN(..))", returning = "retVal") 
    public void afterGetReturn(List<Product> retVal) {
        for (Product product : retVal) {
        	logger.info("Someone is looking for product: {}",  product.getName());
		}
    }
}
