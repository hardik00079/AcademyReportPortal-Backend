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

import com.group.model.AccountManager;
import com.group.model.Trainee;
import com.group.service.AccountManagerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/accountmanager")
public class AccountManagerController {

	private AccountManagerService accountManagerService;

	@Autowired
	public AccountManagerController(AccountManagerService accountManagerService) {
		super();
		this.accountManagerService = accountManagerService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AccountManager>> getAll(){
		
		return ResponseEntity.ok(accountManagerService.retriveAccountmanagers());
	}

	@RequestMapping("/id/{id}")
	public ResponseEntity<AccountManager> findById(@PathVariable Long id){
		return ResponseEntity.ok(accountManagerService.retrieveAccountManager(id));
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<AccountManager> createAccountManager(@RequestBody AccountManager accountManager) {
		return ResponseEntity.ok(accountManagerService.createAccountManager(accountManager));
	}
	
	@PutMapping("/update")
	public ResponseEntity<AccountManager> update(@RequestBody AccountManager accountManager){
		return ResponseEntity.ok(accountManagerService.updateAccountManager(accountManager));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AccountManager> delete(@PathVariable Long id){
		accountManagerService.deleteAccountmanagerById(id);
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/firstName/{firstName}")
	public ResponseEntity<AccountManager> findByFirstName(@PathVariable String firstName){
		return ResponseEntity.ok(accountManagerService.findAccountmanagerByFirstName(firstName));
	}
	
	@RequestMapping("/lastName/{lastName}")
	public ResponseEntity<AccountManager> findByLastName(@PathVariable String lastName){
		return ResponseEntity.ok(accountManagerService.findAccountmanagerByLastName(lastName));
	}
	
	@RequestMapping("/email/{email}")
	public ResponseEntity<AccountManager> findByEmail(@PathVariable String email){
		return ResponseEntity.ok(accountManagerService.findAccountmanagerByEmail(email));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/username/{username}")
	public ResponseEntity<AccountManager> findByUsername(@PathVariable String username){
		return ResponseEntity.ok(accountManagerService.findAccountmanagerByUsername(username));
	}
	
	@PostMapping("/loginValidation")
	public ResponseEntity<Boolean> loginValidation(@RequestBody Trainee trainee){
		return ResponseEntity.ok(accountManagerService.validateLogin(trainee.getUsername(), trainee.getPassword()));
	}
	
	
}
