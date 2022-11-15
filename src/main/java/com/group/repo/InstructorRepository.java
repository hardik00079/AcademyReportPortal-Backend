package com.group.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.model.Instructor;
import com.group.model.Trainee;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

	Optional<Instructor> findByEmail(String email);

	Optional<Instructor> findByFirstName(String firstName);

	Optional<Instructor> findByLastName(String lastName);

	Optional<Instructor> findByUsername(String username);

	

}
