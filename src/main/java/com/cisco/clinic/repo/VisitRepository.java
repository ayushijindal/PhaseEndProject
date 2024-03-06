package com.cisco.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cisco.clinic.model.Visit;


public interface VisitRepository extends JpaRepository<Visit, Long>{

}
