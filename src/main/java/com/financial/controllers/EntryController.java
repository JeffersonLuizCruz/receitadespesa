package com.financial.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financial.entities.Entry;
import com.financial.repositories.filter.EntryFilter;
import com.financial.services.EntryServiceImpl;

import event.EventLocationHeader;

@RestController
@RequestMapping(value = "entries")
public class EntryController {

	@Autowired private EntryServiceImpl entryService;
	@Autowired private ApplicationEventPublisher eventPublisher;
	
	
	@PostMapping
	public ResponseEntity<Entry> save(@RequestBody @Valid Entry entry, HttpServletResponse response){
		Entry saveEntry = entryService.save(entry);
		
		eventPublisher.publishEvent(new EventLocationHeader(this, response, saveEntry.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveEntry);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Entry> update(@PathVariable Long id, @Valid @RequestBody Entry entry) {
		try {
			Entry updateEntry = entryService.update(id, entry);
			return ResponseEntity.ok(updateEntry);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Entry> findById(@PathVariable Long id) {
		Entry entry = entryService.findById(id);
		
		return entry != null ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public Page<Entry> search(EntryFilter entryFilter, Pageable pageable) {
		
		return entryService.listAll(entryFilter, pageable);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		entryService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
