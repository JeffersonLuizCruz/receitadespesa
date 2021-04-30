package com.financial.services.crudservice;

import com.financial.entities.Person;


public interface PersonService {
	
	
	public Person save(Person person);
	
	public Person update(Long id, Person person);

	public Person findById(Long id);
	
	public void delete(Long id);
	

}
