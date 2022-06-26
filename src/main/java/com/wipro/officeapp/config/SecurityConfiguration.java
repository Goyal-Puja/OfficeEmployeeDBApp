package com.wipro.officeapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.jdbcAuthentication().dataSource(dataSource)
		.withUser("puja").password(encoder.encode("12345@puja")).roles("OFFICE_ADMIN")
		.and()
		.withUser("dhara").password(encoder.encode("543210")).roles("OFFICE_MANAGER")
		.and()
		.withUser("muskan").password(encoder.encode("987654")).roles("HR");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors().disable();
		http.csrf().disable();
		http.authorizeRequests()
		 .antMatchers("/office/**").permitAll()
		 .antMatchers("/employee/**").hasAnyRole("OFFICE_ADMIN")
		 .antMatchers("/address/**").hasAnyRole("OFFICE_ADMIN","OFFICE_MANAGER")
		 .antMatchers("/empsalary/**").hasAnyRole("OFFICE_ADMIN","OFFICE_MANAGER","HR")
		 .and()
		 .exceptionHandling().accessDeniedPage("/office/accessDenied");
		
		 super.configure(http);
	}

	
	
//	@Bean
//	PasswordEncoder encoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}

}
