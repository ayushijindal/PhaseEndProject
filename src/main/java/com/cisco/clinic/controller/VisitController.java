package com.cisco.clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.clinic.model.Visit;
import com.cisco.clinic.service.VisitService;


@RestController
@RequestMapping("/api/visit")
public class VisitController {
	@Autowired
	private VisitService service;
	
	
	@GetMapping
	public ResponseEntity<List<Visit>> getAllVisits(){
		return new ResponseEntity<List<Visit>>(service.getAllVisits(),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getVisitById(@PathVariable Long id){
		Visit foundUser= service.getVisitById(id);
		if(foundUser!=null)
			return new ResponseEntity<Object>(foundUser,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No Visiter found with Id "+id,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Object> addVisit(@RequestBody Visit user){
		Visit createdUser = service.addVisit(user);;
		if(createdUser!=null)
			return new ResponseEntity<Object>(createdUser,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while creating User",
					HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteViistById(@PathVariable Long id){
		if(service.getVisitById(id)!=null) {
			service.deleteVisitById(id);
			return new ResponseEntity<Object>("Visitor Deleted with Id "+id,HttpStatus.OK);
		}else
			return new ResponseEntity<Object>("No Visitor found to delete with ID "+id,HttpStatus.NOT_FOUND);
	}

}
