package com.asso.frontend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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
	
	@Autowired
    private CustomProperties props;

    /**
    * Get all employees
    * @return An iterable of all employees
    */

    public Iterable<User> getEmployees() {
        String baseApiUrl = props.getApiUrl();
        String getUsersUrl = baseApiUrl + "/users";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<User>> response = restTemplate.exchange(
                getUsersUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<User>>() {}
                );

        //log.debug("Get Users call " + response.getStatusCode().toString());
        
        return response.getBody();
    }


}
