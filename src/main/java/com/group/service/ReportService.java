package com.group.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.model.Instructor;
import com.group.model.Report;
import com.group.model.Trainee;
import com.group.model.User;
import com.group.repo.InstructorRepository;
import com.group.repo.ReportRepository;
import com.group.repo.TraineeRepository;
import com.group.repo.UserRepository;

@Service
public class ReportService {

	private ReportRepository reportRepository;
	private TraineeRepository traineeRepository;
	private InstructorRepository instructorRepository;
	private UserRepository userRepository;

	public ReportService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public ReportService(ReportRepository reportRepository, TraineeRepository traineeRepository, InstructorRepository instructorRepository, UserRepository userRepository) {
		super();
		this.reportRepository = reportRepository;
		this.traineeRepository = traineeRepository;
		this.instructorRepository = instructorRepository;
		this.userRepository = userRepository;
		
	}

	public List<Report> retriveReports() {
	//	System.out.println(reportRepository.findAll());
		return reportRepository.findAll();
	}

	public List<Report> retrieveReport(Long id) {
		Optional<User> user = userRepository.findById(id);
		System.out.println(user+ " this is the user");

		if (!user.isPresent()) {
			throw new NullPointerException("Report with User_id " + id + " not found");
		} else {
			List<Report> optTicket = reportRepository.findByOwner(user.get());
			System.out.println(optTicket);
			return optTicket;
		}

	}

	public Report createReport(Long userId,Long userId2, Report report) {
		Optional<User>  i  = userRepository.findById(userId);
		Optional<Instructor> t = instructorRepository.findById(userId2);
//		System.out.println(userId+" one");
//		System.out.println(userId2+" two");
//		System.out.println(t+ " instructor");
//		System.out.println(i+ "trainee");
		report.setOwner(i.get());
		report.setInstructor(t.get());
		return reportRepository.save(report);
	}

	public void updateReport(Report report) {
		// TODO Auto-generated method stub

		reportRepository.save(report);
	}

	public void requestReportTraineeforbyAM(String traineeUserid, String reportid) {
		// TODO Auto-generated method stub

		Optional<Trainee> trainee = traineeRepository.findById(Long.parseLong(traineeUserid));
		Optional<Report> report = reportRepository.findById(reportid);

		if (!report.isPresent() && !trainee.isPresent()) {
			throw new NullPointerException(
					"Ticket with id " + reportid + " or AccademyAdmin Id" + traineeUserid + " not found");
		} else {
			report.get().setTraineeFor(trainee.get());
			reportRepository.save(report.get());
		}

	}

	public void deleteReportById(String id) {
		// TODO Auto-generated method stub
		reportRepository.deleteById(id);
	}
	
	

}
