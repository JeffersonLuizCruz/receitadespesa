package com.financial.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.entities.Person;
import com.financial.repositories.PersonRepository;
import com.financial.services.crudservice.PersonService;
import com.financial.services.exceptions.NotFoundException;


@Service
public class PersonServiceImpl implements PersonService{

	@Autowired private PersonRepository personRepository;
	
	@Override
	public Person save(Person person) {
		
		return personRepository.save(person);
	}

	@Override
	public Person update(Long id, Person person) {
		Person saveByPerson = findById(id);
		
		BeanUtils.copyProperties(person, saveByPerson, "id");
		
		return personRepository.save(saveByPerson);
	}

	@Override
	public Person findById(Long id) {
		return verifyIfExists(id);
	}

	@Override
	public void delete(Long id) {
		verifyIfExists(id);
		personRepository.deleteById(id);
		
	}
	
	private Person verifyIfExists(Long id) {
		Optional<Person> result = personRepository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("Não existe usuário com esse id: " + id));
	}

}
