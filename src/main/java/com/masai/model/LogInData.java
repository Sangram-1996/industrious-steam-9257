package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class LogInData {
	
	@Id
	@NotNull
	private Integer userId;
	@NotNull(message="username shouldn't be empty")
	private String userName;
	@NotNull(message="password shouldn't be empty")
	private String password;
	
	@NotNull(message="userType shouldn't be empty")
private String usertype;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	

	

}
