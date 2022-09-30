package com.masai.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.Model.Customer;



public interface CustomerService {
	
	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public String deleteCustomer(Integer customer_id);

	public Customer viewCustomer(Integer customerId);

//	List<Customer> viewAllCustomers();

//boolean validateCustomer(String userName, String password);
}
