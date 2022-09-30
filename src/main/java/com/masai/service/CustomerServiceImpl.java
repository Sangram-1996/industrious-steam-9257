package com.masai.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Model.Customer;
import com.masai.Repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custrepo;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer cst= custrepo.save(customer);
		return cst;
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer cust = custrepo.findById(customer.getCustomer_id())
				.orElseThrow(() -> new EntityNotFoundException("Currently No Customer is available with this id"));
		cust.setCustomer_email(customer.getCustomer_email());
		cust.setCustomer_email(customer.getCustomer_name());
		cust.setCustomer_email(customer.getCustomer_password());
		cust.setCustomer_email(customer.getCustomer_username());
		cust.setAddress(customer.getAddress());
		
		Customer cst= custrepo.save(customer);
		return cst;
		
	}

	@Override
	public String deleteCustomer(Integer customer_id) {
		// TODO Auto-generated method stub
		Optional<Customer> cust = custrepo.findById(customer_id);
		if(cust!= null)
		{
			custrepo.deleteById(customer_id);
			return "Record Is Deleted";
		}
		else
		{
			return "Id Is not available in database";
		}
		
	}

	@Override
	public Customer viewCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}