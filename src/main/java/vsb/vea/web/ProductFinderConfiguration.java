package vsb.vea.web;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductFinderConfiguration {
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
