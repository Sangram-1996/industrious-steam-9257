package com.masai.Controller;


import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.masai.Model.Customer;
import com.masai.Service.*;

@RestController
public class CustomerController {
	
	@org.springframework.beans.factory.annotation.Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer( @RequestBody Customer customer) {
		Customer c=customerService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(c,HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) 
	{
		Customer cust = customerService.updateCustomer(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cust.getCustomer_id()).toUri();
		return ResponseEntity.created(location).body(cust);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeletteCustomer(@PathVariable("id") Integer customer_id) 
	{
		String cust = customerService.deleteCustomer(customer_id);
		return new ResponseEntity<String>(cust, HttpStatus.OK);
	}
	
}
