package com.greatlearning.springbootmvcapp.springbootmvcapplication.utils;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.springbootmvcapp.springbootmvcapplication.model.Role;
import com.greatlearning.springbootmvcapp.springbootmvcapplication.model.User;
import com.greatlearning.springbootmvcapp.springbootmvcapplication.repository.RoleRepository;
import com.greatlearning.springbootmvcapp.springbootmvcapplication.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationBootStrapData implements ApplicationListener<ApplicationReadyEvent> {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	private final PasswordEncoder passwordEncoder;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
//		Role userRole = Role.builder().role("ROLE_USER").build();
//		Role adminRole = Role.builder().role("ROLE_ADMIN").build();
//		this.roleRepository.save(userRole);
//		this.roleRepository.save(adminRole);
//
//
//		User shravan = User.builder().name("shravan").email("sv@gmail.com").password(passwordEncoder.encode("welcome"))
//				.build();
//		shravan.addRole(userRole);
//		shravan.addRole(adminRole);
//
//		User aman = User.builder().name("aman").email("aman@gmail.com").password(passwordEncoder.encode("welcome"))
//				.build();
//		aman.addRole(userRole);
//		
//		this.userRepository.save(shravan);
//		this.userRepository.save(aman);
		
	System.out.println("Users uploaded into User Repository");
	}

}
