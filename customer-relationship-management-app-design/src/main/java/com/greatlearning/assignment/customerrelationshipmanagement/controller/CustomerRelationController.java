package com.greatlearning.assignment.customerrelationshipmanagement.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.assignment.customerrelationshipmanagement.entity.Customer;
import com.greatlearning.assignment.customerrelationshipmanagement.service.CRMService;

@Controller
@RequestMapping("/customers")
public class CustomerRelationController {
	
	@Autowired
	private CRMService crmService;
	
	@RequestMapping("/home")
	public String registrationHome(Model theModel) {
		List<Customer> customers = crmService.findAllCustomers();
		theModel.addAttribute("customers",customers);
		return "registrations-list-home";
	}
	
	@GetMapping("/registration")
	public String addCustomer(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		return "registration-form";
	}
	
	@PostMapping("/addcustomer")
	public String saveCustomerInfo(@RequestParam("firstName") String first_name,
			@RequestParam("lastName") String last_name, @RequestParam("email") String email,
			@RequestParam("country") String country, Model theModel) {
	
		System.out.println("Entered the funtion save customer Info()");
		Customer customer = Customer.builder().firstName(first_name).lastName(last_name).email(email)
				.country(country).build();
		theModel.addAttribute("customer",customer);
		crmService.save(customer);
		return "create-notification";
	}
	
	
	@Transactional
	@RequestMapping("/deletecustomer")
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteCustomer(@RequestParam(value = "customerId") int id, Model theModel) {
		System.out.println("Entered the funtion deleteStudent()");
		Customer customer = crmService.getById(id);
		if (customer == null) {
			throw new RuntimeException("Customer with customer Id " + id + " does not exist");
		} else {
			crmService.deleteById(customer.getCustomerId());
			theModel.addAttribute("customer", customer);
			return "delete-notification";
		}
 
		
	}
	
	@GetMapping("/loadform")
	public String loadForm(@RequestParam("customerId") int id, Model theModel) {
		System.out.println("Entered the funtion loadForm()");
		Customer customer = crmService.getById(id);
		theModel.addAttribute("customer", customer);
		return "update-form";
	}
	
	
	@PostMapping("/updatecustomer")
	//@ResponseBody
//	@ResponseStatus(HttpStatus.CREATED)
	public String updateCustomerInfo(@RequestParam("customerId") int id, @RequestParam("firstName") String first_name,
			@RequestParam("lastName") String last_name, @RequestParam("email") String email,
			@RequestParam("country") String country,Model theModel) {
		System.out.println("Entered the funtion updateStudentInfo()");
		Customer customer = crmService.getById(id);
		customer.setFirstName(first_name);
		customer.setLastName(last_name);
		customer.setEmail(email);
		customer.setCountry(country);
		crmService.save(customer);
		theModel.addAttribute("customer", customer);
		return "update-notification";
	}
}
