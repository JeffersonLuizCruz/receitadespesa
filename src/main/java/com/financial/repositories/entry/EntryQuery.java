package com.financial.repositories.entry;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.financial.entities.Entry;
import com.financial.repositories.filter.EntryFilter;
import com.financial.repositories.projection.ResultEntry;

public interface EntryQuery {
	
	public Page<Entry> filter(EntryFilter entryFilter, Pageable pageable);
	
	
	public Page<ResultEntry> result(EntryFilter entryFilter, Pageable pageable);

}
