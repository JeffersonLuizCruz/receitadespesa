package com.financial.serviceinterfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.financial.dto.PersonRequestDto;
import com.financial.entity.Person;

public interface PersonInterfaces {
	
	
	public Person save(Person person);
	
	public Person update(Long id, Person person);

	public Person getById(Long id);
	
	public Page<Person> listAll(PersonRequestDto personRequestDto, Pageable pageable);
	
	public void delete(Long id);
	

}
