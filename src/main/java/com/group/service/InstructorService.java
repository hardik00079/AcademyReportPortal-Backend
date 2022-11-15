package com.group.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.model.Instructor;
import com.group.model.Trainee;
import com.group.repo.InstructorRepository;


@Service
public class InstructorService {
	private InstructorRepository instructorRepository;

	@Autowired
	public InstructorService(InstructorRepository instructorRepository) {
		super();
		this.instructorRepository = instructorRepository;
	}
	
	
	
	public InstructorService() {
		super();
		// TODO Auto-generated constructor stub
	}



	public List<Instructor> retriveInstructors(){
		 System.out.println(instructorRepository.findAll());
		 return instructorRepository.findAll();
	 }
	 
	 

	public Instructor retrieveInstructor(Long id) {
			
			Optional<Instructor> optInstructor = instructorRepository.findById(id);
			
			if(!optInstructor.isPresent()) {
				throw new NullPointerException("Instructor with id " + id + " not found");
			} else {
				return optInstructor.get();
			}
			
		}
	 public Instructor findInstructorByEmail(String email) {
			Optional<Instructor> instructor = instructorRepository.findByEmail(email);
			
			if(instructor.isPresent()) return instructor.get();
			
			throw new NullPointerException("User not found.");
		}

		public Instructor createInstructor(@Valid Instructor instructor) {
			
			return instructorRepository.save(instructor);
		}

		public Instructor updateInstructor(Instructor instructor) {
			// TODO Auto-generated method stub
			return instructorRepository.save(instructor);
		}

		public void deleteInstructorById(Long id) {
			// TODO Auto-generated method stub
			instructorRepository.deleteById(id);
		}
		public Instructor findInstructorByFirstName(String firstName) {
			Optional<Instructor> instructorOptional = instructorRepository.findByFirstName(firstName);
			
			if(instructorOptional.isPresent()) return instructorOptional.get();
			
			throw new NullPointerException("User not found.");
		}
		
		public Instructor findInstructorByLastName(String lastName) {
			Optional<Instructor> instructor = instructorRepository.findByLastName(lastName);
			
			if(instructor.isPresent()) return instructor.get();
			
			throw new NullPointerException("User not found.");
		}

		public Instructor findInstructorByUsername(String username) {
			Optional<Instructor> instructor = instructorRepository.findByUsername(username);
			
			if(instructor.isPresent()) return instructor.get();
			
			throw new NullPointerException("User not found.");
		}
		
		public boolean validateLogin(String username, String password) {
			if(findInstructorByUsername(username).getPassword().equals(password)) return true;
			
			return false;
		}
}
