package vsb.vea.web;

import java.util.List;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import vsb.vea.models.Product;

@Aspect
@Component
public class ProductFinderAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@AfterReturning(pointcut = "execution(* vsb.vea.services.ProductService.get())", returning = "returnValue") 
    public void afterGetReturn(List<Product> returnValue) throws Throwable {
        for (Product product : returnValue) {
        	logger.info("There is product: {}",  product);
		}
    }
}
