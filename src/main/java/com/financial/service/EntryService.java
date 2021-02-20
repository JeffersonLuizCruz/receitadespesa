package com.financial.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.financial.dto.EntryRequestDto;
import com.financial.dto.EntryResponseDto;
import com.financial.enttry.Entry;
import com.financial.interfaces.EntryInterfaces;

public class EntryService implements EntryInterfaces{

	@Override
	public Entry save(Entry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry update(Long id, Entry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry getById(Long id) {
		// TODO Auto-generated method stub
		return null;
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
