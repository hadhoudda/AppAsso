package com.asso.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/createUser")
	public String createUser(Model model) {
		User e = new User();
		model.addAttribute("user", e);
		return "formNewUser";
	}
	
	@GetMapping("/updateUser/{id}")
	public String updateUser(@PathVariable("id") final int id, Model model) {
		User e = service.getUser(id);		
		model.addAttribute("user", e);	
		return "formUpdateUser";		
	}
	
	@GetMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable("id") final int id) {
		service.deleteUser(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		if(user.getId() != null) {
			// User from update form has the password field not filled,
			// so we fill it with the current password.
			User current = service.getUser(user.getId());
			user.setPassword(current.getPassword());
		}
		service.saveUser(user);
		return new ModelAndView("redirect:/");	
	}
	
}
