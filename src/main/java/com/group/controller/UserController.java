package com.group.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.model.User;
import com.group.service.UserService;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {


	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/username/{username}")
	public ResponseEntity<User> findByUsername(@PathVariable String username){
		return ResponseEntity.ok(userService.findUserByUsername(username));
	}
	
	@PostMapping("/loginValidation")
	public ResponseEntity<Boolean> loginValidation(@RequestBody User user, HttpSession session){
		boolean uservalidate = userService.validateLogin(user.getUsername(), user.getPassword());
		if(uservalidate == true) {
		session.setAttribute(User.LOGGED_IN_USER_SESSION, user);}
		return ResponseEntity.ok(uservalidate);
		
		
	}
	
	    @GetMapping("/users/loggedin")
	    public Optional<User> loggedin(HttpSession session) throws Exception {

	    	return userService.loggedInUser(session);
	    }
}
