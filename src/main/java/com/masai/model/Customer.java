package com.masai.model;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.masai.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity

public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer customer_id;
	
	@NotNull
	@Size(min = 4, max = 20, message = "Name of the Customer must have 4 to 20 Characters")
	private String customer_name;
	
	@NotNull
	@Size(min = 1, max = 25, message = "Email of the Customer must have 1 to 25 Characters")
	private String customer_email;
	
	@NotNull
	@Size(min = 4, max = 15, message = "Username of the Customer must have 4 to 15 Characters")
	private String customer_username;
	
	@NotNull
	@Size(min = 4, max = 15, message = "Password of the Customer must have 4 to 15 Characters")
	private String customer_password;
	
	@Embedded
	private Address address;
	
	
	
	public Customer(Integer customer_id,
			@Size(min = 4, max = 20, message = "Name of the Customer must have 4 to 20 Characters") String customer_name,
			String customer_email, String customer_username, String customer_password, Address address) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_email = customer_email;
		this.customer_username = customer_username;
		this.customer_password = customer_password;
		this.address = address;
	}






	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_email="
				+ customer_email + ", customer_username=" + customer_username + ", customer_password="
				+ customer_password + ", address=" + address + "]";
	}






	public Integer getCustomer_id() {
		return customer_id;
	}






	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}






	public String getCustomer_name() {
		return customer_name;
	}






	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}






	public String getCustomer_email() {
		return customer_email;
	}






	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}






	public String getCustomer_username() {
		return customer_username;
	}






	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}






	public String getCustomer_password() {
		return customer_password;
	}






	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}






	public Address getAddress() {
		return address;
	}






	public void setAddress(Address address) {
		this.address = address;
	}






	public Customer()
	{
		
	}
	
	//@Embedded
	//private Address address;
	//private Address address;
	
}
