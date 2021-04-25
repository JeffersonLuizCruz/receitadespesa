package com.financial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.entities.Category;
import com.financial.repositories.CategoryRepository;
import com.financial.services.crudservice.CategoryServiceInterfaces;
import com.financial.services.exceptions.NotFoundException;

@Service
public class CategoryServiceImpl implements CategoryServiceInterfaces{
	
	@Autowired private CategoryRepository categoryRepository;

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getById(Long id) {
		Optional<Category> result = categoryRepository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("Não existe categoria com esse id: " + id));
	}

	@Override
	public List<Category> listAll() {
		return categoryRepository.findAll();
	}
	
	

}
