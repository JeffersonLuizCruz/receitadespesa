package com.financial.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.financial.entities.Person;
import com.financial.repositories.PersonRepository;
import com.financial.services.crudservice.PersonServiceInterfaces;
import com.financial.services.exceptions.NotFoundException;
import com.financial.services.pagemodel.PageModel;
import com.financial.services.pagemodel.PageRequestModel;
import com.financial.specification.PersonSpecification;

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
		
		BeanUtils.copyProperties(person, saveByPerson, "id");
		
		return personRepository.save(saveByPerson);
	}

	@Override
	public Person getById(Long id) {
		Optional<Person> result = personRepository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("Não existe usuário com esse id: " + id));
	}

	@Override
	public PageModel<Person> listAllByOnLazyModel(PageRequestModel prm) {
		Pageable pageable = prm.toSpringPageRequest();
		Specification<Person> spec = PersonSpecification.search(prm.getSearch());
		
		Page<Person> page = personRepository.findAll(spec, pageable);
		
		PageModel<Person> pm = new PageModel<>(
							(int)page.getTotalElements(),
							page.getSize(),
							page.getTotalPages(),
							page.getContent());
		
		return pm;
	}

	@Override
	public void delete(Long id) {
		getById(id);
		personRepository.deleteById(id);
		
	}

}
