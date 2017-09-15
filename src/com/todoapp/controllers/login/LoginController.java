package com.todoapp.controllers.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.todoapp.services.login.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	LoginService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String displayLoginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@RequestParam String name, @RequestParam String password, ModelMap model) {
		boolean isValidUser = service.validateUser(name, password);
		if(isValidUser){
			model.put("name", name);
			return "welcome";
		}
		else{
			model.put("errorMessage", "Invalid credentials!!");
			return "login";
		}
	}
	
	@RequestMapping(value="/error")
	public String error(){
		return "error";

	}

}
