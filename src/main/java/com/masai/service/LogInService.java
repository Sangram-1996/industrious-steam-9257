package com.masai.service;



import com.masai.exception.LogInException;
import com.masai.model.LogInData;

public interface LogInService {
	
	

	public String logInAccount(LogInData loginData)throws LogInException ;
	public String logOutFromAccount(String key) throws LogInException;


}
