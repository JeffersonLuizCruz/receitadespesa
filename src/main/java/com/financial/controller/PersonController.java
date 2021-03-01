package com.financial.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financial.entity.Person;
import com.financial.serviceinterfaces.PersonServiceInterfaces;

import event.EventLocationHeader;

@RestController
@RequestMapping(value = "persons")
public class PersonController {
	
	@Autowired PersonServiceInterfaces personService;
	@Autowired private ApplicationEventPublisher eventPublisher;
	
	
	@PostMapping
	public ResponseEntity<Person> save(@RequestBody Person person, HttpServletResponse response){
		Person savePerson = personService.save(person);
		
		//Adiciona o Location do recurso criado
		eventPublisher.publishEvent(new EventLocationHeader(this, response, savePerson.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savePerson);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
		Person updatePerson = personService.update(id, person);
		
		return ResponseEntity.ok(updatePerson);
		
	}
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Person> getById(@PathVariable Long id) {
		Person person = personService.getById(id);
		
		return ResponseEntity.ok(person);
		
	}
	

}
