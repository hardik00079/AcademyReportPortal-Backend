package com.group.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.model.Instructor;
import com.group.model.Report;
import com.group.model.Trainee;
import com.group.repo.InstructorRepository;
import com.group.repo.TraineeRepository;



@Service
public class TraineeService {

	private TraineeRepository traineeRepository;
	private InstructorRepository instructorRepository;

	@Autowired
	public TraineeService(TraineeRepository traineeRepository, InstructorRepository instructorRepository) {
		super();
		this.traineeRepository = traineeRepository;
		this.instructorRepository = instructorRepository;
	}

	public TraineeService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Trainee> retriveTrainees(){
		 System.out.println(traineeRepository.findAll());
		 return traineeRepository.findAll();
	 }
	 
	 public Trainee retrieveTrainee(Long id) {
			
			Optional<Trainee> optTrainee = traineeRepository.findById(id);
			
			if(!optTrainee.isPresent()) {
				throw new NullPointerException("Trainee with id " + id + " not found");
			} else {
				return optTrainee.get();
			}
			
		}
	 public Trainee findTraineeByEmail(String email) {
			Optional<Trainee> trainee = traineeRepository.findByEmail(email);
			
			if(trainee.isPresent()) return trainee.get();
			
			throw new NullPointerException("User not found.");
		}

		public Trainee createTrainee(@Valid Trainee trainee) {
			
			return traineeRepository.save(trainee);
		}

		public Trainee updateTrainee(Trainee trainee) {
			// TODO Auto-generated method stub
			return traineeRepository.save(trainee);
		}

		public void deleteTraineeById(Long id) {
			// TODO Auto-generated method stub
			traineeRepository.deleteById(id);
		}
		public Trainee findTraineeByFirstName(String firstName) {
			Optional<Trainee> trainee = traineeRepository.findByFirstName(firstName);
			
			if(trainee.isPresent()) return trainee.get();
			
			throw new NullPointerException("User not found.");
		}
		
		public Trainee findTraineeByLastName(String lastName) {
			Optional<Trainee> trainee = traineeRepository.findByLastName(lastName);
			
			if(trainee.isPresent()) return trainee.get();
			
			throw new NullPointerException("User not found.");
		}

		public Trainee findTraineeByUsername(String username) {
			Optional<Trainee> trainee = traineeRepository.findByUsername(username);
			
			if(trainee.isPresent()) return trainee.get();
			
			throw new NullPointerException("User not found.");
		}
		
		public boolean validateLogin(String username, String password) {
			if(findTraineeByUsername(username).getPassword().equals(password)) return true;
			
			return false;
		}

		public void requestReportTraineeforbyAM(String traineeuserId, String instId) {
			// TODO Auto-generated method stub
			Optional<Trainee> trainee = traineeRepository.findById(Long.parseLong(traineeuserId));
			Optional<Instructor> instructor = instructorRepository.findById(Long.parseLong(instId));

			if (!instructor.isPresent() && !trainee.isPresent()) {
				throw new NullPointerException(
						"instructor with id " + instId + " or Trainee Id" + traineeuserId + " not found");
			} else {
				trainee.get().setAssignee(instructor.get());;
				traineeRepository.save(trainee.get());
			}
		}


}
