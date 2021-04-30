package com.financial.services.crudservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.financial.entities.Entry;
import com.financial.repositories.filter.EntryFilter;
import com.financial.repositories.projection.ResultEntry;

public interface EntryService {
	
	
	public Entry save(Entry entry);
	public Entry update(Long id, Entry entry);
	public Entry findById(Long id);
	public Page<Entry> listAll(EntryFilter entryFilter, Pageable pageable);
	public void delete(Long id);
	public Page<ResultEntry> result(EntryFilter erd, Pageable pageable);
	

}
