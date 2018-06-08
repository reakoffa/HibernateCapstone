package com.securityex.SecurityDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.securityex.SecurityDemo.dao.UsersRepository;
import com.securityex.SecurityDemo.service.CustomUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true) // this is added for the @PreAuthorize annotation in the
													// HomeController
@EnableWebSecurity // this will enable spring security for us
@EnableJpaRepositories(basePackageClasses = UsersRepository.class) // This will inject the classes for jpa
@Configuration // lets spring know that this is a configuration file
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService usersDS;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usersDS).passwordEncoder(getPasswordEncoder());
	}
	
	

	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {

			@Override
			public String encode(CharSequence arg0) {
				return arg0.toString();
			}

			@Override
			public boolean matches(CharSequence arg0, String arg1) {
				return true;
			}
			
		};
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//disable cross-site request forgery
		http.csrf().disable();
		
		//authorize secure users
		http.authorizeRequests().antMatchers("/admin/**").authenticated()
		.anyRequest().permitAll().and().formLogin()  // insert here for for custom login: .loginPage("/loginpage");
		.permitAll();
		
	}

}
