package com.financial.controllers;

import java.util.List;

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

import com.financial.entities.Category;
import com.financial.services.CategoryServiceImpl;

import event.EventLocationHeader;

@RestController
@RequestMapping(value = "categories")
public class CategoryController {
	
	@Autowired private CategoryServiceImpl categoryService;
	@Autowired private ApplicationEventPublisher eventPublisher;
	
	
	@PostMapping
	public ResponseEntity<Category> save(@RequestBody Category category, HttpServletResponse response){
		Category saveCategory = categoryService.save(category);
		
		//Adicionando um Location Header no cabeçalho HTTP
		eventPublisher.publishEvent(new EventLocationHeader(this, response, saveCategory.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCategory);
	}
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Category> getById(@PathVariable Long id) {
		Category category = categoryService.getById(id);
		
		return ResponseEntity.ok(category);
	}
	
	@GetMapping
	public List<Category> listAll() {
		return categoryService.listAll();
	}

}
