package com.group.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.model.Report;
import com.group.model.User;

public interface ReportRepository extends JpaRepository<Report, String> {
	List<Report> findByOwner(User owner);


}
