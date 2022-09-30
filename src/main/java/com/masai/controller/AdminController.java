package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.LogInException;
import com.masai.model.SignUpData;
import com.masai.service.SignUpService;



@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private SignUpService signupservice;
	
	
   @GetMapping("/allcustomers")
	public ResponseEntity<List<SignUpData>>  showallcustomers() throws CustomerException{
		
	   
	 
			List<SignUpData> customers = signupservice.showallcustomers();
			return new ResponseEntity<List<SignUpData>>(customers, HttpStatus.OK);
		}
	   
	
	@DeleteMapping("/{id}")
public ResponseEntity<SignUpData>  deletecustomer(@PathVariable Integer id) throws CustomerException{

	SignUpData customers = signupservice.deletecustomer(id);
	return new ResponseEntity<SignUpData>(customers, HttpStatus.OK);
}
	
	
}

	

