package com.group.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.model.AccountManager;
import com.group.model.Trainee;
import com.group.repo.AccountManagerRepository;

@Service
public class AccountManagerService {
	private AccountManagerRepository accountmanagerRepository;

	@Autowired
	public AccountManagerService(AccountManagerRepository accountmanagerRepository) {
		super();
		this.accountmanagerRepository = accountmanagerRepository;
	}

	public AccountManagerService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<AccountManager> retriveAccountmanagers() {
		System.out.println(accountmanagerRepository.findAll());
		return accountmanagerRepository.findAll();
	}

	public AccountManager retrieveAccountManager(Long id) {

		Optional<AccountManager> accOptional = accountmanagerRepository.findById(id);

		if (!accOptional.isPresent()) {
			throw new NullPointerException("Trainee with id " + id + " not found");
		} else {
			return accOptional.get();
		}

	}

	public AccountManager findAccountmanagerByEmail(String email) {
		Optional<AccountManager> accOptional = accountmanagerRepository.findByEmail(email);

		if (accOptional.isPresent())
			return accOptional.get();

		throw new NullPointerException("User not found.");
	}

	public AccountManager createAccountManager(@Valid AccountManager accountManager) {

		return accountmanagerRepository.save(accountManager);
	}

	public AccountManager updateAccountManager(AccountManager accountManager) {
		// TODO Auto-generated method stub
		return accountmanagerRepository.save(accountManager);
	}

	public void deleteAccountmanagerById(Long id) {
		// TODO Auto-generated method stub
		accountmanagerRepository.deleteById(id);
	}

	public AccountManager findAccountmanagerByFirstName(String firstName) {
		Optional<AccountManager> accOptional = accountmanagerRepository.findByFirstName(firstName);

		if (accOptional.isPresent())
			return accOptional.get();

		throw new NullPointerException("User not found.");
	}

	public AccountManager findAccountmanagerByLastName(String lastName) {
		Optional<AccountManager> accOptional = accountmanagerRepository.findByLastName(lastName);

		if (accOptional.isPresent())
			return accOptional.get();

		throw new NullPointerException("User not found.");
	}

	public AccountManager findAccountmanagerByUsername(String username) {
		Optional<AccountManager> accOptional = accountmanagerRepository.findByUsername(username);

		if (accOptional.isPresent())
			return accOptional.get();

		throw new NullPointerException("User not found.");
	}

	public boolean validateLogin(String username, String password) {
		if (findAccountmanagerByUsername(username).getPassword().equals(password))
			return true;

		return false;
	}
}
