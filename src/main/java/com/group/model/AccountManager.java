package com.group.model;

import javax.persistence.Entity;

@Entity
public class AccountManager extends User {

	public AccountManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountManager(Long userId, String username, String email, String firstName, String lastName,
			String password, String role) {
		super(userId, username, email, firstName, lastName, password, role);
		// TODO Auto-generated constructor stub
	}

	

}
