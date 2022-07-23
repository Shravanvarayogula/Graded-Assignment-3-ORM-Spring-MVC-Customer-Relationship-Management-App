package com.greatlearning.springbootmvcapp.springbootmvcapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.springbootmvcapp.springbootmvcapplication.model.Role;
import com.greatlearning.springbootmvcapp.springbootmvcapplication.model.User;


public interface RoleRepository extends JpaRepository<User, Long>{

	void save(Role userRole);
	

}
