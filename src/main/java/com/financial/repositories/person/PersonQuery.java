package com.financial.repositories.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.financial.entities.Person;
import com.financial.repositories.filter.PersonFilter;

public interface PersonQuery {
	
	public Page<Person> findByPerson(PersonFilter personFilter, Pageable pageable);

}

