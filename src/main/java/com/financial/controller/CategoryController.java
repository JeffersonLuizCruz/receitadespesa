package com.financial.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financial.enttry.Category;
import com.financial.repository.CategoryRepository;

import event.EventLocationHeader;

@RestController
@RequestMapping(value = "categories")
public class CategoryController {
	
	@Autowired private CategoryRepository categoryRepository;
	@Autowired private ApplicationEventPublisher eventPublisher;
	
	
	@PostMapping
	public ResponseEntity<Category> save(@RequestBody Category category, HttpServletResponse response){
		Category saveCategory = categoryRepository.save(category);
		
		//Adicionando um Location Header no cabeçalho HTTP
		eventPublisher.publishEvent(new EventLocationHeader(this, response, saveCategory.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCategory);
	}
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Category> getById(@PathVariable Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		
		return null == category.get() ? ResponseEntity.notFound().build() : ResponseEntity.ok(category.get());
	}
	
	@GetMapping
	public List<Category> listAll() {
		return categoryRepository.findAll();
	}

}
