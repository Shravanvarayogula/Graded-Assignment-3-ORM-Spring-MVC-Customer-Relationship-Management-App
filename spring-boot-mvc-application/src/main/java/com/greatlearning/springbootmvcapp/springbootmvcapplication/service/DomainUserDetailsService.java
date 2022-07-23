package com.greatlearning.springbootmvcapp.springbootmvcapplication.service;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.springbootmvcapp.springbootmvcapplication.model.DomainUserDetails;
import com.greatlearning.springbootmvcapp.springbootmvcapplication.model.User;
import com.greatlearning.springbootmvcapp.springbootmvcapplication.repository.UserRepository;

@Service
@Primary
public class DomainUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	public DomainUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = this.userRepository.findByName(username);
		if (optionalUser.isPresent()) {
			return new DomainUserDetails(optionalUser.get());
		}
		throw new UsernameNotFoundException("Bad Credentials");

	}

}
