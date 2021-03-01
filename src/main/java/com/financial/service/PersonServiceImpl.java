package com.financial.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.financial.entity.Person;
import com.financial.entity.page.PageModel;
import com.financial.entity.page.PageRequestModel;
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
		Specification<Person> spec = UserSpecification.search(prm.getSearch());
		
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
		// TODO Auto-generated method stub
		
	}

}
