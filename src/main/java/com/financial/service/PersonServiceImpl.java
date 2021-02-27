package com.financial.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.financial.dto.PersonRequestDto;
import com.financial.entity.Person;
import com.financial.exceptions.NotFoundException;
import com.financial.repository.PersonRepository;
import com.financial.serviceinterfaces.PersonServiceInterfaces;

@Service
public class PersonServiceImpl implements PersonServiceInterfaces{

	@Autowired private PersonRepository personRepository;
	
	@Override
	public Person save(Person person) {
		
		return personRepository.save(person);
	}

	@Override
	public Person update(Long id, Person person) {
		Person saveByPerson = getById(id);
		
		if(saveByPerson == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(person, saveByPerson, "id");
		
		return personRepository.save(saveByPerson);
	}

	@Override
	public Person getById(Long id) {
		Optional<Person> result = personRepository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("Não existe usuário com esse id: " + id));
	}

	@Override
	public Page<Person> listAll(PersonRequestDto personRequestDto, Pageable pageable) {
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
