package vsb.vea.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class ProductFinderSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void initGlobal(AuthenticationManagerBuilder builder) throws Exception {

		// Simple hardcoded example
		builder.inMemoryAuthentication().withUser("lukas").password("{noop}lukas").roles("CLIENT", "REVIEWER");
		builder.inMemoryAuthentication().withUser("client").password("{noop}client").roles("CLIENT");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
		http.authorizeRequests().antMatchers("/management/**").authenticated().and()
				.formLogin()
				.loginPage("/login")
				.permitAll().and()
				.logout().permitAll().invalidateHttpSession(true)
				.logoutSuccessUrl("/").permitAll().and().exceptionHandling().accessDeniedPage("/403");
	}
}
