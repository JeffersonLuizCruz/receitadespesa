package com.financial.service;


import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.financial.dto.EntryRequestDto;
import com.financial.dto.EntryResponseDto;
import com.financial.entity.Entry;
import com.financial.entity.Person;
import com.financial.entity.page.PageModel;
import com.financial.entity.page.PageRequestModel;
import com.financial.repository.EntryRepository;
import com.financial.repository.PersonRepository;
import com.financial.serviceinterfaces.EntryServiceInterfaces;
import com.financial.specification.EntrySpecification;
import com.financial.specification.PersonSpecification;
import com.financial.exceptions.BadRequestException;
import com.financial.exceptions.NotFoundException;

@Service
public class EntryServiceImpl implements EntryServiceInterfaces{

	
	@Autowired private PersonRepository personRepository;
	@Autowired private EntryRepository entryRepository;
	
	
	@Override
	public Entry save(Entry entry) {
		Optional<Person> person = personRepository.findById(entry.getPerson().getId());
		
		if(person == null || !person.get().getActive()) {
			throw new BadRequestException("Usuário já existe ou inativo na base de dados!");
		}
		
		return entryRepository.save(entry);
	}

	@Override
	public Entry update(Long id, Entry entry) {
		Entry saveByEntry = getById(id);
		try {
			
			if(!entry.getPerson().equals(saveByEntry.getPerson())) {
				isActivePerson(saveByEntry);
			}	
			
		} catch (NullPointerException e) {
			
		}
		BeanUtils.copyProperties(entry, saveByEntry, "id", "paymentDate", "expirationDate");
		return entryRepository.save(saveByEntry);
	}

	@Override
	public Entry getById(Long id) {
		Optional<Entry> result = entryRepository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("Não existe lançamento com esse id: " + id));
	}

	@Override
	public Page<Entry> listAllByOnLazyModel(PageRequestModel prm) {
		Pageable pageable = prm.toSpringPageRequest();
		Specification<Entry> spec = EntrySpecification.search(prm.getSearch());
		
		Page<Entry> page = personRepository.findAll(spec, pageable);
		
		PageModel<Entry> pm = new PageModel<>(
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

	@Override
	public Page<EntryResponseDto> result(EntryRequestDto entryRequestDto, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private void isActivePerson(Entry entry) {
		Person person = null;
		
		if(entry.getPerson().getId() != null) {
			person = (personRepository.findById(entry.getPerson().getId())
					.orElseThrow(() -> new NotFoundException("Não há esse usuário: " + entry.getPerson().getId())));
		}
		
		if(person == null || !person.getActive()) {
			throw new NotFoundException("Esse usuário está fora do sistema - [OFF]: " + person.getActive());
		}
	}


}
