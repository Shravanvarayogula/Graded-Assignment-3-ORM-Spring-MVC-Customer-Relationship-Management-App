package com.greatlearning.springbootmvcapp.springbootmvcapplication.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface ApplicationConfig {
	public PasswordEncoder passwordEncoder();

}
