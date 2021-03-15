package com.financial.serviceinterfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.financial.entity.Entry;
import com.financial.repository.filter.EntryRequestDto;
import com.financial.repository.projection.ResultEntry;

public interface EntryServiceInterfaces {
	
	
	public Entry save(Entry entry);
	
	public Entry update(Long id, Entry entry);
	
	public Entry getById(Long id);
	
	public Page<Entry> listAllByOnLazyModel(EntryRequestDto entryRequestDtp, Pageable pageable);
	
	public void delete(Long id);
	
	public Page<ResultEntry> result(EntryRequestDto erd, Pageable pageable);
	

}
