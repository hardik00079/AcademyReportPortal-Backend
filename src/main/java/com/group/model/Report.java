package com.group.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Report {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private String name;
	private Date dateCreated;
	private Boolean visable;
	@ManyToOne
	@JoinColumn(name="owner_id")
	@JsonIgnore
	private User owner;
	private String description;
	@ManyToOne
	@JoinColumn(name="Trainee_id")
	private Trainee traineeFor;
	
	@ManyToOne
	@JoinColumn(name="Instructor_id")
	private Instructor instructor;
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(String name, Date dateCreated, User owner, String description,Boolean visable, Trainee traineeFor, Instructor instructor) {
		super();
		this.name = name;
		this.dateCreated = dateCreated;
		this.owner = owner;
		this.description = description;
		this.traineeFor = traineeFor;
		this.instructor = instructor;
		this.visable = visable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Trainee getTraineeFor() {
		return traineeFor;
	}

	public void setTraineeFor(Trainee traineeFor) {
		this.traineeFor = traineeFor;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", name=" + name + ", dateCreated=" + dateCreated + ", owner=" + owner
				+ ", description=" + description + ", traineeFor=" + traineeFor + "]";
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Boolean getVisable() {
		return visable;
	}

	public void setVisable(Boolean visable) {
		this.visable = visable;
	}
	
	
	
	
}
