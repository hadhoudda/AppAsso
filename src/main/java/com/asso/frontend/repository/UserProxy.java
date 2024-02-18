package com.asso.frontend.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.asso.frontend.CustomProperties;
import com.asso.frontend.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserProxy {
	
	private final static Logger log = LoggerFactory.getLogger(UserProxy.class);
	
	@Autowired
    private CustomProperties props;

    /**
    * Get all employees
    * @return An iterable of all employees
    */

    public Iterable<User> getUsers() {
        String baseApiUrl = props.getApiUrl();
        String getUsersUrl = baseApiUrl + "/users";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<User>> response = restTemplate.exchange(
                getUsersUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<User>>() {}
                );

        log.debug("Get Users call " + response.getStatusCode().toString());
        
        return response.getBody();
    }
    
    /**
	 * Get an useer by the id
	 * @param id The id of the employee
	 * @return The employee which matches the id
	 */
	public User getUser(int id) {
		String baseApiUrl = props.getApiUrl();
		String getUserUrl = baseApiUrl + "/users/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> response = restTemplate.exchange(
				getUserUrl, 
				HttpMethod.GET, 
				null,
				User.class
			);
		
		log.debug("Get User call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
    
    /*
     * create user
     */

    public User createUser(User e) {
    	
        String baseApiUrl = props.getApiUrl();
        String createUserUrl = baseApiUrl + "/users";
        
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<User>(e);
        ResponseEntity<User> response = restTemplate.exchange(
            createUserUrl,
            HttpMethod.POST,
            request,
            User.class);

        log.debug("Create User call " + response.getStatusCode().toString());

        return response.getBody();
    }
    
    /**
	 * Update an user - using the PUT HTTP Method.
	 * @param e Existing user to update
	 */
	public User updateUser(User e) {
		String baseApiUrl = props.getApiUrl();
		String updateUserUrl = baseApiUrl + "/users/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<User> request = new HttpEntity<User>(e);
		ResponseEntity<User> response = restTemplate.exchange(
				updateUserUrl, 
				HttpMethod.PUT, 
				request, 
				User.class);
		
		log.debug("Update User call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Delete an user using exchange method of RestTemplate
	 * instead of delete method in order to log the response status code.
	 * @param e The employee to delete
	 */
	public void deleteUser(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteUserUrl = baseApiUrl + "/users/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteUserUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete User call " + response.getStatusCode().toString());
	}
}
