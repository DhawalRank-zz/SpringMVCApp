package com.todoapp.services.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("dhawal") && password.equals("dhawal");
	}

}