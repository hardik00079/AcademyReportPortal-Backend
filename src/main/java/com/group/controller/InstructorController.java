package com.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.model.Instructor;
import com.group.model.Trainee;
import com.group.service.InstructorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

	private InstructorService instructorService;

	@Autowired
	public InstructorController(InstructorService instructorService) {
		super();
		this.instructorService = instructorService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Instructor>> getAll(){
		
		return ResponseEntity.ok(instructorService.retriveInstructors());
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<Instructor> findById(@PathVariable Long id){
		return ResponseEntity.ok(instructorService.retrieveInstructor(id));
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
		return ResponseEntity.ok(instructorService.createInstructor(instructor));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Instructor> update(@RequestBody Instructor instructor){
		return ResponseEntity.ok(instructorService.updateInstructor(instructor));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Instructor> delete(@PathVariable Long id){
		instructorService.deleteInstructorById(id);
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/firstName/{firstName}")
	public ResponseEntity<Instructor> findByFirstName(@PathVariable String firstName){
		return ResponseEntity.ok(instructorService.findInstructorByFirstName(firstName));
	}
	
	@RequestMapping("/lastName/{lastName}")
	public ResponseEntity<Instructor> findByLastName(@PathVariable String lastName){
		return ResponseEntity.ok(instructorService.findInstructorByLastName(lastName));
	}
	
	@RequestMapping("/email/{email}")
	public ResponseEntity<Instructor> findByEmail(@PathVariable String email){
		return ResponseEntity.ok(instructorService.findInstructorByEmail(email));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/username/{username}")
	public ResponseEntity<Instructor> findByUsername(@PathVariable String username){
		return ResponseEntity.ok(instructorService.findInstructorByUsername(username));
	}
	
	@PostMapping("/loginValidation")
	public ResponseEntity<Boolean> loginValidation(@RequestBody Trainee trainee){
		return ResponseEntity.ok(instructorService.validateLogin(trainee.getUsername(), trainee.getPassword()));
	}
	
	
}

