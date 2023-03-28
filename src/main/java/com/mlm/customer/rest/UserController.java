package com.mlm.customer.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public //List<User> 
    String getUsers() {
        //List<User> users = userRepository.findAll();
        return "users";
    }
}
