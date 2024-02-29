package com.asso.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.asso.frontend.model.User;
import com.asso.frontend.repository.UserProxy;

import lombok.Data;

@Data
@Service
public class UserService {

	 @Autowired
	    private UserProxy userProxy;

	    public User getUser(final int id) {
	        return userProxy.getUser(id);
	    }

	    public Iterable<User> getUsers() {
	        return userProxy.getUsers();
	    }
	    
	    public void deleteUser(final int id) {
	        userProxy.deleteUser(id);;
	    }

	    public User saveUser(User user) {
	       User savedUser;

	        // Règle de gestion : Le nom de famille doit être mis en majuscule.
	       user.setLastName(user.getLastName().toUpperCase());

	       if(user.getId() == null) {
	           // Si l'id est nul, alors c'est un nouvel utilisateur.
	           savedUser = userProxy.createUser(user);
	       } else {
	           savedUser = userProxy.updateUser(user);
	       }
	    
	       return savedUser;
	    }
}
