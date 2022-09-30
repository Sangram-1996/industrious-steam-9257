package com.masai.service;



import java.util.List;

import com.masai.exception.LogInException;
import com.masai.model.SignUpData;

public interface SignUpService {
	
public SignUpData createNewSignUp(SignUpData signUp) throws LogInException;
	
	public SignUpData updateSignUpDetails(SignUpData signUp,String key) throws LogInException;
	
	public List<SignUpData> showallcustomers()throws LogInException;
	
	public SignUpData deletecustomer(Integer userId)throws LogInException;

}
