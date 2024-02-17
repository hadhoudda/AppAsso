package com.asso.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asso.frontend.model.User;
import com.asso.frontend.repository.UserProxy;

import lombok.Data;

@Data
@Service
public class UserService {

    @Autowired
    private UserProxy userProxy;

//    public User getEmployee(final int id) {
//        return userProxy.getUser(id);
//    }
//
//    public Iterable<User> getEmployees() {
//        return userProxy.getUsers();
//    }
//
//    public void deleteEmployee(final int id) {
//        userProxy.deleteUser(id);;
//    }
//
//     public User saveEmployee(User user) {
//        User savedEmployee;
//
//        // Règle de gestion : Le nom de famille doit être mis en majuscule.
//        user.setLastName(employee.getLastName().toUpperCase());
//
//        if(employee.getId() == null) {
//            // Si l'id est nul, alors c'est un nouvel employé.
//            savedEmployee = userProxy.createUser(user);
//        } else {
//            savedEmployee = userProxy.updateUser(user);
//        }
//    
//        return savedEmployee;
//    }


}
