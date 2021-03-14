package com.financial.serviceinterfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.financial.dto.EntryRequestDto;
import com.financial.dto.EntryResponseDto;
import com.financial.entity.Entry;
import com.financial.entity.page.PageRequestModel;

public interface EntryServiceInterfaces {
	
	
	public Entry save(Entry entry);
	
	public Entry update(Long id, Entry entry);
	
	public Entry getById(Long id);
	
	public Page<Entry> listAllByOnLazyModel(PageRequestModel prm);
	
	public void delete(Long id);
	
	public Page<EntryResponseDto> result(EntryRequestDto erd, Pageable pageable);
	

}
