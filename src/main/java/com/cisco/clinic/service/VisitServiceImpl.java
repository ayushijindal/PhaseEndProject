package com.cisco.clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.clinic.model.Visit;
import com.cisco.clinic.repo.VisitRepository;

@Service
public class VisitServiceImpl implements VisitService{
	@Autowired
	private VisitRepository repo;

	@Override
	public List<Visit> getAllVisits() {
		return repo.findAll();
	}

	@Override
	public Visit getVisitById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Visit addVisit(Visit visit) {
		return repo.save(visit);
	}

	@Override
	public void deleteVisitById(Long id) {
		repo.deleteById(id);
		
	}

}
