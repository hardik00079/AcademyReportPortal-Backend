package com.group.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instructor extends User {
	@ManyToOne
	@JoinColumn(name="Trainee_id")
	private Trainee traineeFor;
	
	@JsonIgnore
	@OneToMany(mappedBy="assignee")
	private List<Trainee> assignedTraineeReports;
	@JsonIgnore
	@OneToMany(mappedBy="instructor")
	private List<Report> listreports;
	
	public Instructor(Trainee traineeFor) {
		super();
		this.traineeFor = traineeFor;
	}

	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Instructor(Long userId, String username, String email, String firstName, String lastName, String password,
			String role) {
		super(userId, username, email, firstName, lastName, password, role);
		// TODO Auto-generated constructor stub
	}

	public Trainee getTraineeFor() {
		return traineeFor;
	}

	public void setTraineeFor(Trainee traineeFor) {
		this.traineeFor = traineeFor;
	}

	public List<Trainee> getAssignedTraineeReports() {
		return assignedTraineeReports;
	}

	public void setAssignedTraineeReports(List<Trainee> assignedTraineeReports) {
		this.assignedTraineeReports = assignedTraineeReports;
	}

	public List<Report> getListreports() {
		return listreports;
	}

	public void setListreports(List<Report> listreports) {
		this.listreports = listreports;
	}
	
	
	

}
