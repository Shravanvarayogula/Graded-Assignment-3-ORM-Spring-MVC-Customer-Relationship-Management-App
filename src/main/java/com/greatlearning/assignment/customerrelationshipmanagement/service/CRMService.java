package com.greatlearning.assignment.customerrelationshipmanagement.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.assignment.customerrelationshipmanagement.entity.Customer;

public interface CRMService {

	public List<Customer> findAllCustomers();

	public List<Customer> saveAllCustomers();

	public Customer getById(int id);

	public void save(Customer customer);

	public Optional<Customer> findById(Integer id);

	public boolean existsById(Integer id);

	public void deleteById(Integer id);

	public String delete(Customer customer);

	public void deleteAll();

}
