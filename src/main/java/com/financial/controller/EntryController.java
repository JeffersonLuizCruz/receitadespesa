package com.financial.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financial.entity.Entry;
import com.financial.service.EntryService;

import event.EventLocationHeader;

@RestController
@RequestMapping(value = "entries")
public class EntryController {

	@Autowired EntryService entryService;
	@Autowired private ApplicationEventPublisher eventPublisher;
	
	
	@PostMapping
	public ResponseEntity<Entry> save(@RequestBody Entry entry, HttpServletResponse response){
		Entry saveEntry = entryService.save(entry);
		
		//Adiciona o Location do recurso criado
		eventPublisher.publishEvent(new EventLocationHeader(this, response, saveEntry.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveEntry);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Entry> update(@PathVariable Long id, @RequestBody Entry entry) {
		try {
			Entry updateEntry = entryService.update(id, entry);
			return ResponseEntity.ok(updateEntry);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Entry> getById(@PathVariable Long id) {
		Entry entry = entryService.getById(id);
		
		return entry != null ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
	}
}
