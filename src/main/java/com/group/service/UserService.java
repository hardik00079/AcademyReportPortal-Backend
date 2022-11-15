package com.group.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.model.User;
import com.group.repo.UserRepository;


@Service
public class UserService {
	private UserRepository userRepository;

	public UserService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User findUserByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		
		if(user.isPresent()) return user.get();
		
		throw new NullPointerException("User not found.");
	}
	public boolean validateLogin(String username, String password) {
		System.out.println(username+" hajah "+password);
		if(findUserByUsername(username).getPassword().equals(password)) return true;
		
		return false;
	}
	
	public Optional<User> loggedInUser(HttpSession session)  {
		return Optional.ofNullable((User) session.getAttribute(User.LOGGED_IN_USER_SESSION));
	}



}
