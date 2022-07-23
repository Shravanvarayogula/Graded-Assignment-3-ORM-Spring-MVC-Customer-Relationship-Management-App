package com.greatlearning.assignment.customerrelationshipmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.assignment.customerrelationshipmanagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
