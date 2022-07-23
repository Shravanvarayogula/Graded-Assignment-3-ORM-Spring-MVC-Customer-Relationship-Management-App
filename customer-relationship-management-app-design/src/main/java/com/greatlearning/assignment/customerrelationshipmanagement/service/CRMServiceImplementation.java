package com.greatlearning.assignment.customerrelationshipmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.assignment.customerrelationshipmanagement.entity.Customer;
import com.greatlearning.assignment.customerrelationshipmanagement.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CRMServiceImplementation implements CRMService {

	@Autowired

	private CustomerRepository customerrepo;

	@Override
	public List<Customer> findAllCustomers() {
		log.info("Fetching All Customers from Database");
		return customerrepo.findAll();
	}

	@Override
	public List<Customer> saveAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Customer getById(int id) {
		log.info("Fetching Customer Information from Database");

		Customer customerobj = customerrepo.getById(id);
		Customer customer = Customer.builder().customerId(customerobj.getCustomerId())
				.firstName(customerobj.getFirstName()).lastName(customerobj.getLastName()).email(customerobj.getEmail())
				.country(customerobj.getCountry()).build();
		return customer;
	}

	@Override
	public void save(Customer customer) {
		log.info("Saving Customer Information to Database");
		customerrepo.save(customer);
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		log.info("Fetching Customer Information by ID from Database");
		Optional<Customer> customer = customerrepo.findById(id);
		return Optional.of(customer.get());
	}

	@Override
	public boolean existsById(Integer id) {
		log.info("Checking Customer Information existence by ID from Database");

		return customerrepo.existsById(id);

	}

	@Override
	public void deleteById(Integer id) {
		log.info("Deleting Customer Information by ID from Database");
		customerrepo.deleteById(id);
	}

	@Override
	public String delete(Customer customer) {
		log.info("Deleting Customer Information by ID from Database");

		int id = customer.getCustomerId();
		if (customerrepo.existsById(id)) {
			customerrepo.deleteById(id);
			return "Deleted Customer";
		} else
			return "Customer Not Found";

	}

	@Override
	public void deleteAll() {
		customerrepo.deleteAll();

	}

}
