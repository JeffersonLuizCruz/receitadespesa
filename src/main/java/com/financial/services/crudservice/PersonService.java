package com.financial.services.crudservice;

import java.util.List;

import com.financial.entities.Person;


public interface PersonService {
	
	Person save(Person person);
	Person update(Long id, Person person);
	Person findById(Long id);
	List<Person> listAll();
	void delete(Long id);
	

}
