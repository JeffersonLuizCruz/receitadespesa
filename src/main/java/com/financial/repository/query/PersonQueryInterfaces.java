package com.financial.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.financial.dto.PersonRequestDto;
import com.financial.entity.Person;

@Deprecated
public interface PersonQueryInterfaces {
	
	public Page<Person> findByPerson(PersonRequestDto personRequestDto, Pageable pageable);

}
