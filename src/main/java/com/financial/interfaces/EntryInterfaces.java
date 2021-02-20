package com.financial.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.financial.dto.EntryRequestDto;
import com.financial.dto.EntryResponseDto;
import com.financial.enttry.Entry;

public interface EntryInterfaces {
	
	
	public Entry save(Entry entry);
	
	public Entry update(Long id, Entry entry);
	
	public Entry getById(Long id);
	
	public Page<Entry> listAll(EntryRequestDto entryRequestDto, Pageable pageable);
	
	public void delete(Long id);
	
	public Page<EntryResponseDto> result(EntryRequestDto entryRequestDto, Pageable pageable);
	

}
