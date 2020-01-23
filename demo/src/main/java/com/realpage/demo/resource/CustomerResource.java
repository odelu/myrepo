package com.realpage.demo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.realpage.demo.pojo.Customer;
import com.realpage.demo.service.CustomerService;

@RestController
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customer/{customerId}")
	public Optional<Customer> getCustomer(@PathVariable("customerId") int customerId) {
		return customerService.getCustomers().stream().filter(customer -> customer.getId() == customerId).findAny();
	}
}
