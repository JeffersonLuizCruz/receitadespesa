package com.financial.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.financial.dto.PersonRequestDto;
import com.financial.entity.Person;

public class PersonQueryImpl implements PersonQueryInterfaces{

	@Override
	public Page<Person> filter(PersonRequestDto personRequestDto, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
