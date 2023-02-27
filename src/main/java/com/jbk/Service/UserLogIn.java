package com.jbk.Service;

import com.jbk.Entity.CustomerDTO;


public interface UserLogIn {
	
	public String logIntoAccount(CustomerDTO userDto);
	
	public String logOutFromAccount(String key);
}