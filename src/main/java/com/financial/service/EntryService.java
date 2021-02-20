package com.financial.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.financial.dto.EntryRequestDto;
import com.financial.dto.EntryResponseDto;
import com.financial.enttry.Entry;
import com.financial.enttry.Person;
import com.financial.exceptions.PersonException;
import com.financial.interfaces.EntryInterfaces;
import com.financial.repository.EntryRepository;
import com.financial.repository.PersonRepository;

@Service
public class EntryService implements EntryInterfaces{

	
	@Autowired PersonRepository personRepository;
	@Autowired EntryRepository entryRepository;
	
	
	@Override
	public Entry save(Entry entry) {
		Person person = personRepository.existsById(entry.getPerson().isActive());
		
		if(null == person || !person.isActive()) {
			throw new PersonException("Usuário já existe ou inativo na base de dados!");
		}
		
		return entryRepository.save(entry);
	}

	@Override
	public Entry update(Long id, Entry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry getById(Long id) {
		Optional<Entry> entry = entryRepository.findById(id);
		
		if(null == entry) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return entry.get();
	}

	@Override
	public Page<Entry> listAll(EntryRequestDto entryRequestDto, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
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


}
