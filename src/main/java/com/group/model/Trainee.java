package com.group.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trainee extends User {
	@JsonIgnore
	@OneToMany(mappedBy="traineeFor")
	private List<Report> traineereports;
	
	@ManyToOne
	@JoinColumn(name="assignee_id")
	private Instructor assignee;
	
	public Trainee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trainee(List<Report> traineereports) {
		super();
		this.traineereports = traineereports;
	}
	public Trainee(Long userId,String username, String email, String firstName, String lastName, String password
			,String role) {
		super(userId, username, email, firstName, lastName, password, role);
	}
	public List<Report> getTraineereports() {
		return traineereports;
	}
	public void setTraineereports(List<Report> traineereports) {
		this.traineereports = traineereports;
	}
	public Instructor getAssignee() {
		return assignee;
	}
	public void setAssignee(Instructor assignee) {
		this.assignee = assignee;
	}
	
	
}
