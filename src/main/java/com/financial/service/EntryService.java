package com.financial.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.financial.exceptions.NotFoundException;

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
	
	
	private void isActivePerson(Entry entry) {
		Person person = null;
		
		if(entry.getPerson().getId() != null) {
			person = (personRepository.findById(entry.getPerson().getId())
					.orElseThrow(() -> new NotFoundException("Não há esse usuário: " + entry.getPerson().getId())));
		}
		
		if(person == null || !person.isActive()) {
			throw new NotFoundException("Esse usuário está fora do sistema - [OFF]: " + person.isActive());
		}
	}


}
