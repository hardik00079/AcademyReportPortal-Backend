package com.group.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.model.AccountManager;

public interface AccountManagerRepository extends JpaRepository<AccountManager, Long> {

	Optional<AccountManager> findByEmail(String email);

	Optional<AccountManager> findByFirstName(String firstName);

	Optional<AccountManager> findByLastName(String lastName);

	Optional<AccountManager> findByUsername(String username);

}
