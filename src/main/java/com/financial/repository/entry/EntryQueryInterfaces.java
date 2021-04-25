package com.financial.repository.entry;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.financial.entities.Entry;
import com.financial.repository.filter.EntryRequestDto;
import com.financial.repository.projection.ResultEntry;

public interface EntryQueryInterfaces {
	
	public Page<Entry> filter(EntryRequestDto entryRequestDto, Pageable pageable);
	
	
	public Page<ResultEntry> result(EntryRequestDto entryRequestDto, Pageable pageable);

}
