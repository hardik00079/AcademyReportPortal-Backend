package com.group.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

import com.group.model.Report;
import com.group.model.Trainee;
import com.group.service.TraineeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/trainees")
public class TraineeController {

	private TraineeService traineeService;

	@Autowired
	public TraineeController(TraineeService traineeService) {
		super();
		this.traineeService = traineeService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Trainee>> getAll(){
		
		return ResponseEntity.ok(traineeService.retriveTrainees());
	}
	@RequestMapping("/id/{id}")
	public ResponseEntity<Trainee> findById(@PathVariable Long id){
		return ResponseEntity.ok(traineeService.retrieveTrainee(id));
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Trainee> createTrainee(@RequestBody Trainee trainee) {
		return ResponseEntity.ok(traineeService.createTrainee(trainee));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Trainee> update(@RequestBody Trainee trainee){
		return ResponseEntity.ok(traineeService.updateTrainee(trainee));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Trainee> delete(@PathVariable Long id){
		traineeService.deleteTraineeById(id);
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/firstName/{firstName}")
	public ResponseEntity<Trainee> findByFirstName(@PathVariable String firstName){
		return ResponseEntity.ok(traineeService.findTraineeByFirstName(firstName));
	}
	
	@RequestMapping("/lastName/{lastName}")
	public ResponseEntity<Trainee> findByLastName(@PathVariable String lastName){
		return ResponseEntity.ok(traineeService.findTraineeByLastName(lastName));
	}
	
	@RequestMapping("/email/{email}")
	public ResponseEntity<Trainee> findByEmail(@PathVariable String email){
		return ResponseEntity.ok(traineeService.findTraineeByEmail(email));
	}

	@PostMapping("/requestReportTraineeforbyAM")
	public ResponseEntity<Report> requestReportTraineeforbyAM(@RequestBody String data ) throws ParseException{
	 	JSONParser parser = new JSONParser();
	 	JSONObject jsonObject = (JSONObject) parser.parse(data);
	 	System.out.println(jsonObject.get("traineeUserid")+" kndcksnckkd " +jsonObject.get("Instid"));
		traineeService.requestReportTraineeforbyAM(String.valueOf(jsonObject.get("traineeUserid")), String.valueOf(jsonObject.get("Instid")));
		return ResponseEntity.ok().build();
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/username/{username}")
	public ResponseEntity<Trainee> findByUsername(@PathVariable String username){
		return ResponseEntity.ok(traineeService.findTraineeByUsername(username));
	}
	
	@PostMapping("/loginValidation")
	public ResponseEntity<Boolean> loginValidation(@RequestBody Trainee trainee){
		return ResponseEntity.ok(traineeService.validateLogin(trainee.getUsername(), trainee.getPassword()));
	}
	
	
}
