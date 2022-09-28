package com.masai.service;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LogInException;
import com.masai.model.SignUpData;
import com.masai.repository.SignUpDao;

@Service
public class SignUpServiceImpl implements SignUpService {


	@Autowired
	private SignUpDao signUpDAO;
	
	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;
	
	@Override
	public SignUpData createNewSignUp(SignUpData newSignUp) throws LogInException  {
		
		Optional<SignUpData> opt = signUpDAO.findByUserName(newSignUp.getUserName());
		if(opt.isPresent())
		{
			throw new LogInException("User Already Exist!");
		}
		
		return signUpDAO.save(newSignUp);
	}

	@Override
	public SignUpData updateSignUpDetails(SignUpData signUp, String key) throws LogInException  {
		
		SignUpData signUpDetails = getCurrentLoginUserSession.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			throw new LogInException("UnAuthorized!!! No User Found....Try To login first!");
		}
		
		if(signUpDetails.getUserId() == signUp.getUserId())
			{
			signUpDAO.save(signUp);
			return signUp;
			}
		else
			throw new LogInException("Can't change UserId!!");
	}

}
