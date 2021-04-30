package com.financial.services;


import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.financial.services.crudservice.EntryService;
import com.financial.services.exceptions.BadRequestException;
import com.financial.services.exceptions.NotFoundException;
import com.financial.entities.Entry;
import com.financial.entities.Person;
import com.financial.repositories.EntryRepository;
import com.financial.repositories.PersonRepository;
import com.financial.repositories.filter.EntryFilter;
import com.financial.repositories.projection.ResultEntry;

@Service
public class EntryServiceImpl implements EntryService{

	
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
	public Page<Entry> listAllByOnLazyModel(EntryFilter entryRequestDto, Pageable pageable) {
		
		return entryRepository.filter(entryRequestDto, pageable);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<ResultEntry> result(EntryFilter entryRequestDto, Pageable pageable) {

		return entryRepository.result(entryRequestDto, pageable);
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
