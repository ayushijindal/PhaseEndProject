package com.cisco.clinic.service;

import java.util.*;


import com.cisco.clinic.model.Visit;


public interface VisitService{
	List<Visit> getAllVisits();
	Visit getVisitById(Long id);
	Visit addVisit(Visit visit);
	void deleteVisitById(Long id);
}
