package com.group.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue
	private Long userId;
	@Column(nullable = false, unique = true)
	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	@OneToMany(mappedBy="owner")
	private List<Report> createdReports;
	public static String  LOGGED_IN_USER_SESSION = "loggedInUser";
	


	public List<Report> getCreatedReports() {
		return createdReports;
	}

	public void setCreatedReportss(List<Report> createdReports) {
		this.createdReports= createdReports;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(Long userId, String username, String email, String firstName, String lastName, String password, String role ) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setCreatedReports(List<Report> createdReports) {
		this.createdReports = createdReports;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long employeeId) {
		this.userId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + "]";
	}
	

}
