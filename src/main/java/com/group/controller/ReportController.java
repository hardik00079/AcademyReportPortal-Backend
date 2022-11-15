package com.group.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.group.model.Instructor;
import com.group.model.Report;
import com.group.service.ReportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reports")
public class ReportController {
	private ReportService reportService;
	@Autowired
	public ReportController(ReportService reportService) {
		super();
		this.reportService = reportService;
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Report>> getAll(){
		System.out.println(reportService.retriveReports());
		return ResponseEntity.ok(reportService.retriveReports());
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<List<Report>> findByOwner(@PathVariable Long id){
		System.out.println(id+" This is report user id ");
		System.out.println(reportService.retrieveReport(id));
		return ResponseEntity.ok(reportService.retrieveReport(id));
	}
	
	@PostMapping("addreport/{userId}/{userId2}")
	public ResponseEntity<Report> createReport(@PathVariable("userId") Long userId, @PathVariable("userId2") Long userId2, @Valid@RequestBody Report report){
		System.out.println(userId+" 1111");
		System.out.println(userId2+" 222");
		reportService.createReport(userId,userId2,report);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Report> updateReport(@Valid@RequestBody Report report){
		reportService.updateReport(report);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/requestReportTraineeforbyAM")
	public ResponseEntity<Report> requestReportTraineeforbyAM(@RequestBody String data ) throws ParseException{
	 	JSONParser parser = new JSONParser();
	 	JSONObject jsonObject = (JSONObject) parser.parse(data);
	 	System.out.println(jsonObject.get("traineeUserid")+" " +jsonObject.get("reportid"));
		reportService.requestReportTraineeforbyAM(String.valueOf(jsonObject.get("traineeUserid")), String.valueOf(jsonObject.get("reportid")));
		return ResponseEntity.ok().build();
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Report> delete(@PathVariable String id){
		reportService.deleteReportById(id);
		
		return ResponseEntity.ok().build();
	}
}
