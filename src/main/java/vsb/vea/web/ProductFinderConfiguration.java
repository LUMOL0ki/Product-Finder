package vsb.vea.web;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc
@Configuration
public class ProductFinderConfiguration implements WebMvcConfigurer{
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
