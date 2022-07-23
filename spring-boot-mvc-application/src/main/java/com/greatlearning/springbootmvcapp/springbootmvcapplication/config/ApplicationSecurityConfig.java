package com.greatlearning.springbootmvcapp.springbootmvcapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final UserDetailsService userDetailsService;

	public ApplicationSecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		// Setting Http Authorization at End point Levels
		http.authorizeRequests()
		.antMatchers("/springbootmvcapp/**")
			.permitAll()	
		.antMatchers(HttpMethod.GET,"/springbootmvcapp/**")
			.hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST,"/springbootmvcapp/**")
			.hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/springbootmvcapp/**")
			.hasAnyRole("ADMIN")
		.anyRequest()
			.fullyAuthenticated()
		.and()
		.httpBasic();
	}

	// Http Authentication check using assigned roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(this.userDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	// One-way Encryption

	@Bean
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
}
