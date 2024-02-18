package com.asso.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.asso.frontend.model.User;
import com.asso.frontend.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service ;
	
	@GetMapping("/")
	public String home(Model model) {
	    Iterable<User> listUser = service.getUsers();
	    model.addAttribute("users", listUser);
	    
	    return "home";
	}
}
