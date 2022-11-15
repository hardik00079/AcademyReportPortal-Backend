package com.group.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.model.Trainee;


public interface TraineeRepository extends JpaRepository<Trainee, Long> {
	Optional<Trainee> findByEmail(String email);

	Optional<Trainee> findByFirstName(String firstName);

	Optional<Trainee> findByLastName(String lastName);

	Optional<Trainee> findByUsername(String username);
}
